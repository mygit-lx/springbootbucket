package com.example.utils.http;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.DateUtil;
import com.example.utils.encrypt.EncryptUtils;
import com.example.utils.encrypt.MD5;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 交互通讯工具类 用来发送http请求和接收http请求参数
 *
 * @author luoxiang
 * @since czbt  2018-06-01
 */
public class CommunicationUtil {

    private static Logger log = LoggerFactory.getLogger(CommunicationUtil.class);

    private static final String KEY = "8thrge84fdhf34894";

    private static final String VERSION = "2.1.2";

    /**
     *
     * <p>
     * 从请求中获得解密后的请求参数值。
     *
     * @param request
     *            :请求
     * @return String:null标示不是合法的api请求，不为null，则表示为合法的请求，此时返回具体的请求数据。
     * @throws </p>
     *
     */
    public static JSONObject getRequestData(HttpServletRequest request) {
        String uploadData = request.getParameter("uploadData");
        log.info("getRequestData-----uploadData:{}",uploadData);
        String apiSrc = request.getHeader("apiSrc");
        log.info("getRequestData-----apiSrc:{}",apiSrc);
        String apiTarget = request.getHeader("apiTarget");
        log.info("getRequestData-----apiTarget:{}",apiTarget);
        String version = request.getHeader("version");
        log.info("getRequestData-----version:{}",version);
        // 判断是否有uploadData参数和header信息，如果没有，则证明不是经过我们的通讯程序发送的请求，则此时返回null
        if (isNullOrEmpty(uploadData) || isNullOrEmpty(apiSrc) || isNullOrEmpty(apiTarget)
                || isNullOrEmpty(version)) {
            return null;
        }
        try {
            Map<String, String> requestmap = JSONObject.parseObject(uploadData, HashMap.class);
            String token = requestmap.get("token");
            String data = requestmap.get("data");
            if (isNullOrEmpty(token) || isNullOrEmpty(data)) {
                log.info("token或data为空--token:{}--data:{}",new String[]{token,data});
                return null;
            }
            /*----------------进行签名校验，签名校验不通过，则返回null----------------*/
            if (!token.equals(MD5.encode(data + KEY))) {
                log.info("md5验签失败！");
                return null;
            }

            /*------------------------------进行解密--------------------------------*/
            String result = EncryptUtils.decrypt3DES(data, KEY);
            log.info("请求参数3des解密：result：{}",result);
            // 解密出的数据为empty也返回null，这样，调用方只需判断是否为null就行，而不需要同时判断empty。
            if (result != null && result.isEmpty()) {
                return null;
            }
            JSONObject jsonObject = JSONObject.parseObject(result);

            /*------------------------------防止接口被恶意调用-----------------------*/
            Long timeStamp = MapUtils.getLong(jsonObject, "timeStamp");
            if (timeStamp != null || Objects.isNull(timeStamp)) {
                log.info("请求参数时间戳不能为空！");
                return null;
            }
            Date date = DateUtil.timeStampToDate(MapUtils.getLong(jsonObject, "timeStamp") * 1000);
            long i = DateUtil.minutesBetween(date, DateUtil.getNow());
            if(i>1){//同一请求不能超过一分钟
                log.info("请求过时！");
                return null;
            }
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * <p>
     * 发送请求的方法 调用该方法完成实际的加密，签名，添加header等功能
     *
     * @param url
     *            :api的完整地址.
     * @param busyContent
     *            :业务数据字符串，通常是业务数据的json格式字符串
     * @param srcCode
     *            :请求的应用代码。
     * @param targetCode
     *            ：接收请求的应用代码.
     * @return Result:请求的返回结果。
     * @throws
     *             </p>
     */
    public static JSONObject sendPost(String url, String busyContent, String srcCode,
                                      String targetCode) {
        JSONObject json = new JSONObject();
        if (url == null || busyContent == null || url.isEmpty()) {
            json.put("respcd", "9999");
            json.put("resptx", "参数不正确");
        } else {
            try {
                // 1）对业务数据进行加密
                String jiamibusyContent = EncryptUtils.encrypt3DES(busyContent, KEY);
                // 2）对上面的内容进行签名
                String token = MD5.encodeSrc(jiamibusyContent + KEY);
                Map<String, String> orginmap = new HashMap<String, String>();
                orginmap.put("data", jiamibusyContent);
                orginmap.put("token", token);
                String uploadData = JSONObject.toJSONString(orginmap);
                // 发送请求的参数map
                Map<String, String> requestmap = new HashMap<String, String>();
                requestmap.put("uploadData", uploadData);
                // 传输header信息
                Map<String, String> requestproperties = new HashMap<String, String>();
                requestproperties.put("apiSrc", srcCode);
                requestproperties.put("apiTarget", targetCode);
                requestproperties.put("version", VERSION);
                // 发送请求
                ServiceRequest requester = new ServiceRequest();
                ServiceResponse res = requester.sendPost(url, requestmap, requestproperties);
                if (res.code == 200) {
                    String responseContent = res.getContent();
                    return JSONObject.parseObject(responseContent);
                } else {
                    json.put("respcd", "999999");
                    json.put("resptx", "未知错误 responseCode:" + res.code);
                }

            } catch (Exception e) {
                log.error(e.getMessage(), e);
                json.put("respcd", "999999");
                json.put("resptx", e.getMessage());
            }
        }
        return json;
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
