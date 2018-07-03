package com.example.common.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ReturnCode
 * @author: liuming
 * @date: 2016年2月23日 下午2:16:35
 */
public enum ReturnCode {

    ACTIVE_EXCEPTION(-1, "异常"),
    ACTIVE_SUCCESS(01, "操作成功"),
    ACTIVE_FAILURE(02, "操作失败"),
    ERROR_PARAMS_NOT_NULL(03, "参数不能为空"),
    ERROR_HEADER_NOT_NULL(04, "请求头不能为空"),
    ERROR_BODY_NOT_NULL(05, "请求体不能为空"),
    ERROR_PARAMS_AMOUNT(06, "参数金额有误"),
    REQUEST_SUCCESS(200, "请求成功"),
    ERROR_PARAMS(400, "参数不完整"),
    ERROR_DUPLICATE(401, "重复操作"),
    ERROR_UNAUTH(401, "认证失败"),
    ERROR_AUTH(402, "无权限"),
    ERROR_PARAMS_DECRYPT(402, "参数解密失败"),
    ERROR_WRONG(403, "用户无法使用此系统"),
    ERROR_RESOURCES(404, "请求资源不存在"),
    ERROR_SIGN(405, "签名Sign缺失"),
    ERROR_INVALID_TOKEN(406, "登录失效，请重新登录！"),
    ERROR_APPKEY(407, "无效的appkey"),
    ERROR_APPLICATION(408, "APPLICATION不能为空"),
    ERROR_PARAMS_FORMAT(500, "参数格式错误"),
    ERROR_SERVER(503, "系统异常"),
    ERROR_USER_TYPE_ERROR(1111, "用户类型参数错误"),
    ERROR_SYSTEM_ON(504,"系统维护中"),

    EXCEPTION(100001, "系统异常"),
    SYS_DOWN(100002, "系统维护中"),
    NOMORE(100000, "正常返回"),

    ERROR_AUTH_TIME(100003,"该时段激活名额已满，请稍后再激活，谢谢配合!"),
    USER_CODE_ERROR(100101, "验证码已过期"),
    USER_CODE_NOTNULL(100106, "验证码不能为空"),
    USER_CODE_EX(100109, "请输入正确验证码"),
    USER_CODE_VALID(100109, "请输入有效邀请码"),
    USER_PHONE_ERROR(100102, "请输入正确手机号码"),
    USER_DOT_EXIST(100103, "用户不存在"),
    USER_ON_EXIST(100104, "当前手机号已被绑定"),
    USER_PHONE_NOTNULL(100105, "手机号不能为空"),
    USER_TYPE_ERROR(100107, "不支持的短信类型"),
    USER_CODE_TOOMANY(100108, "验证码获取频繁，请稍后再试"),
    BALANCE_PWD_ERROR(100109, "交易密码不正确"),
    VERFICATION_CODE(100110, "请输入图形验证码"),

    USER_NOT_NULL(100100, "请输入正确用户名或密码"),
    USER_NOT_AUTH(100300, "用户未认证完成"),
    USER_VERIFY(100301,"暂时无法开通，1个月后可再次申请，感谢您的关注，给您带来的不便，尽请谅解。"),
    USER_VERIFY_OK(100302,"您现在可以去身份认证了"),
    USER_AGE_NOT(100303,"您暂不符开通条件，感谢您的关注！"),
    STU_USER_AGE_NOT(100303,"为响应国家监管政策，学生用户额度停止发放"),
    CITY_NOT_SUPPORT(100304,"目前没有开通业务的城市"),
    COLLEGE_NOT_EXIST(100305,"无开通业务城市"),
    CREDIT_NOT_EXIST(100306,"暂无白条产品，请稍后再下单"),
    USER_CERT_NO_EXIST(100307,"该身份证号已经被绑定"),
    AUTH_WHITE(100308,"请去补充汽车后市场资料"),
    AUTH_PROCESS(100309,"补充资料正在认证中"),

    PLAN_OVER_DUE(100400, "您的账单有逾期，请先还款再下单"),
    
    ACCOUNT_DONT_EXIST(100200, "您的账户已被冻结，暂时无法下单"),
    ACCOUNT_CAN_USE(100201, "账户剩余可用信用额度不足"),
    ACCOUNT_LOW_REPAY(100202,"账户剩余可用信用额度不足，您还有未还账单，先还完账单再试试吧"),
    ACCOUNT_NOT_EXIST(100203, "抱歉，账户不存在！"),
    NOT_SHOW_PLAN(100204, "臣妾查不到，传唤客服问询"),
    ACCOUNT_UPDATE_ERROR(100204,"更新帐户失败，请重试"),
    
    ORDER_NOT_EXIST(100011, "订单不存在"),
    ORDER_NOT_SUBMIT(100012, "此商品三个月内不可重复提交订单"),
    PAY_NOT_SUBMIT(100013, "系统检测，您当前位置不符合支付条件"),
    SCOPE_NOT_SUBMIT(100014, "您的当前位置不在有效服务范围内，请及时联系商家或您的客户经理。"),
    RISK_NOT_SUBMIT(100015,"风控检查年龄不通过"),
    NEVER_ORDER_CAR(100016,"资质不符，您暂时无法办理业务，谢谢您的支持！"),
    REPEAT_ORDER_CAR(100017,"暂时无法下单，请于XXXXXX日后再试。"),
    PRESCOPE_NOT_SUBMIT(100018, "经检测您不在商户门店范围，请前往门店享受分期服务"),
    GPS_ERROR(100019, "GPS获取失败，请重试！"),
    BANK_NOT_SUPPORT(100500,"银行卡不支持，请重新输入支持银行卡信息！"),
    BANK_READ_ERROR(100501,"银行信息读取失败，请及时联系客服！"),

    ORDER_FIRSTPAY(100600, "账户可用信用额度充足,订单有首付"),
    ORDER_NOT_FIRSTPAY(100601, "账户可用信用额度充足,订单零首付"),
    MERC_AMOUNT_NOT_ENOUGH(100602, "商户额度不足！"),
    MERC_AMOUNT_NOT_EXIST(100602, "不存在此商户！"),
    MERC_QR_CODE_ERROR(100604, "商户二维码已过期！"),
    MERC_QR_CODE_BAD(100605, "二维码无效"),
    MERC_STATUS_ERROR(100606, "商户二维码已失效"),

    REPAY_PRE_PLAN(100701,"请先还清之前期数！"),

    ZM_AUTHORIZED(100801,"芝麻信用授权处理完成！"),
    BUSINESS_IN_FREEZE (100801 ,"抱歉，此商户已下架"),
    CATEGORY_IS_SOLDOUT(100802 ,"抱歉，此商品已下架"),
    DATA_GT_THIRTY(100803 ,"导出日期不能大于30天!"),
    STARTIME_GT_ENDTIME(100804 ,"开始时间不能大于结束时间!"),
    OLD_USER(100805 ,"亲爱的桔瓣，我们为您准备了信用钱包，一次认证，额度循环使用。需要麻烦您重新认证一下。"),

    BANK_CODE_NOT_NULL(100901,"银行卡不能为空！"),
    CUSTOMERID_NOT_NULL(100902,"用户id不能为空！"),
    CONTRACTID_NOT_NULL(100903,"还款计划id不能为空！"),
    PERIOD_NOT_NULL(100904,"还款期数不能为空！"),
    FREEINTEREST_NOT_NULL(100905,"滞纳金不能为空！"),
    PHONE_NOT_NULL(100906,"手机号不能为空！"),
    JZFQ_NEVER_AUTH(100908,"永久不能在认证桔子分期"),
    
    GPS_MSG(100909,"为了保障您的账户安全，请进入系统设置或第三方安全软件，打开位置权限。"),
    CERT_NO_USED(100805 ,"身份证号已在桔子分期被另一个手机号使用"),
    AUTH_FIRST(100806 ,"请您优先完成身份认证"),
    AUTH_ING(100807,"额度审核中，请耐心等待"),
    AUTH_NO(100808,"只需3分钟认证"),
    AUTH_FAILD(100809,"很遗憾，额度激活失败"),
    LONGITUDE_ISNULL(100810,"定位失败"),
    LATITUDE_ISNULL(100811,"定位失败"),
    PLATELICENSE_ISNULL(100812,"车牌号不符合规则"),
    FRAMENUMBER_ISNULL(100813,"车架号不符合规则"),
    SEEK_FAILED(100814,"GPS获取失败，请重试!"),

    CARIN_INSURANCE_UNFILLED_ORDER(101100, "暂时无法申请，您尚有正在进行的车险订单"),

    ACTIVITY_TERMINATION(101200,"本次活动已终止"),
	ACTIVITY_END(101201,"本次活动已结束"),

    CAR_INFO_ISNULL(101101,"车辆信息为空"),
    CORE_CUSTOMER_ACCOUNT_UPDATE_FAILED(101300, "核心更新账户信息失败"),

    BUSSINESS_USER_CODE_VALID(101302, "不存在相应企业客户"),
    BUSSINESS_USER_DEL(101303, "该企业暂停开放注册"),
    NO_AUTH(101304,"当前状态无法操作"),
    REASON_IS_NULL(101305,"原因为空！"),
    ENTERPRISEMANAGE_ISNULL(101306, "很抱歉,您所在的企业客户不支持此商户,请您选择企业合作的门店进行下单"),
    ENTERPRISEMANAGE_ISDISABLED(101307, "很抱歉，您所在的企业已停止服务，暂时无法下单"),

    RISK_REFUSE_TYPE1(100000, "暂不符合我司申请条件，请一个月后再试；"),
    RISK_REFUSE_TYPE2(100000, "提供手机号码暂不符合要求，请您更换实名制手机，避免使用虚拟运营商号码；"),
    RISK_REFUSE_TYPE3(100000, "获取数据失败，请您稍后再试；"),
    RISK_REFUSE_TYPE4(100000, "提供车辆不符合我司要求，建议您更换后再试；"),
    RISK_REFUSE_TYPE5(100000, "区域暂未开通业务，敬请期待；"),
    RISK_REFUSE_TYPE6(100000, "由于您在我司存在逾期账单，请您还款后再试；"),
    RISK_REFUSE_TYPE7(100000, "申请条件有误，请您一个月后再试；"),
    RISK_REFUSE_TYPE8(100000, "提供信息无法核实，请您稍后再试；"),
    RISK_REFUSE_TYPE9(100000, "本人放弃；"),
    RISK_REFUSE_TYPE10(100000, "订单被拒绝；"),
    RISK_REFUSE_TYPE11(100000, "信息填写错误，请您核对修改后再试；"),
    RISK_REFUSE_TYPE12(100000, "您此次交易信息核实有误，请您提供准确信息后再试；"),

    CORE_CANCLE_REPAYPLAN_FAILED(101301, "核心取消还款计划失败");

    private int code;

    private String msg;

    private ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCode codeToEnum(int code) {

        ReturnCode[] values = ReturnCode.values();
        for (ReturnCode returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return ACTIVE_EXCEPTION;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, ?> Map() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code, Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":").append(this.code).append(",");
        sb.append("\"msg\":\"").append(this.msg).append("\"}");

        return sb.toString();
    }


}
