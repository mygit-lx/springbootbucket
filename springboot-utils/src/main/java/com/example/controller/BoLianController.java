package com.example.controller;

import com.example.utils.StringUtil;
import com.example.utils.http.HttpClientUtil;
import com.example.utils.number.NumberUtil;
import com.example.utils.wx.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 泊链业务
 */
@RestController
@RequestMapping(value = "/bolian")
public class BoLianController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${bolian.upload_user_url}")
    private String UPLOAD_USER_URL;

    @Value("${bolian.update_user_url}")
    private String UPDATE_USER_URL;

    @Value("${bolian.pay_call_back_url}")
    private String PAY_CALL_BACK_URL;

    @Value("${bolian.quer_curr_order_url}")
    private String QUER_CURR_ORDER_URL;

    @Value("${bolian.quer_car_order_url}")
    private String QUER_CAR_ORDER_URL;

    @Value("${bolian.query_orders_url}")
    private String QUERY_ORDERS_URL;

    @Value("${bolian.propay_order_url}")
    private String PROPAY_ORDER_URL;

    @Value("${bolian.key}")
    private String KEY;

    @Value("${bolian.union_id}")
    private Integer UNION_ID;

    /**
     * 上传车主会员信息
     * @return
     */
    @RequestMapping(value = "/userInfo/upload")
    public String uploadCarUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",UNION_ID+"");//厂商平台的会员编号
        map.put("plate_number","京G39043");//车牌号码
        map.put("union_id",UNION_ID);//联盟身份ID
        map.put("balance","10.30");//会员支付限额
//        map.put("is_prepay",0);//是否是预付
//        map.put("prepay_info","");
        map.put("rand", NumberUtil.getRandom());//随机数

        try {
            logger.info("请求上传车主会员信息Url:{}",UPLOAD_USER_URL);
            String result = HttpClientUtil.postJson(UPLOAD_USER_URL, map,"",KEY);
            logger.info("请求上传车主会员信息响应信息：{}",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 更新车主会员信息
     * @return
     */
    @RequestMapping(value = "/userInfo/update")
    public String updateCarUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",UNION_ID+"");//厂商平台的会员编号
        map.put("type","京G39043");//1更新余额，2删除会员 3更新或添加新车牌 4删除车牌
        map.put("union_id",UNION_ID);//联盟身份ID
        map.put("balance","10.30");//会员支付限额
//        map.put("is_prepay",0);//是否是预付
//        map.put("prepay_info","");
        map.put("plate_number","京G39043");//车牌号码
        map.put("new_plate_number","京G39044");//新车牌号码
        map.put("rand", NumberUtil.getRandom());//随机数

        try {
            logger.info("请求更新车主会员信息Url:{}",UPDATE_USER_URL);
            String result = HttpClientUtil.postJson(UPDATE_USER_URL, map,"",KEY);
            logger.info("请求更新车主会员信息响应信息：{}",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *下单支付回调
     * @return
     */
    @RequestMapping(value = "/pay/callBack")
    public String payCallBack(){
        Map<String,Object> map = new HashMap<>();
        Integer id = 1001;
        map.put("trade_no", StringUtil.Getnum());//交易流水号,16-32位全数字
        map.put("money","0.02");//订单金额，保留两位小数
        map.put("state",1);//支付状态0失败，1成功
        map.put("union_id",id);//厂商平台账户
        map.put("rand", NumberUtil.getRandom());//随机数

        try {
            logger.info("请求下单支付回调信息Url:{}",PAY_CALL_BACK_URL);
            String result = HttpClientUtil.postJson(PAY_CALL_BACK_URL, map,"",KEY);
            logger.info("请求下单支付回调信息响应信息：{}",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取openId
     * @param request
     * @return
     */
    @RequestMapping(value = "/access/openId")
    public String getOpenId(HttpServletRequest request){
        String code = request.getParameter("code");
        Map<String, Object> stringObjectMap = WxUtil.oauth2GetOpenid(code);
        System.out.println(stringObjectMap);
        return null;
    }

}
