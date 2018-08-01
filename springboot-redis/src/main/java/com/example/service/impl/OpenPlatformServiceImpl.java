package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.dao.*;
import com.example.domain.*;
import com.example.enums.DateEnum;
import com.example.enums.FlowStatusEnum;
import com.example.enums.OrderStatusEnum;
import com.example.service.OpenPlatformService;
import com.example.util.DateUtil;
import com.example.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class OpenPlatformServiceImpl implements OpenPlatformService{

    @Autowired
    private OpUserMapper opUserMapper;

    @Autowired
    private OpInsuranceMapper opInsuranceMapper;

    @Autowired
    private OpCarMapper opCarMapper;

    @Autowired
    private OpFlowMapper opFlowMapper;

    @Autowired
    private OpOrderMapper opOrderMapper;


    @Override
    public OpUser findAllOpUser(Integer id) {
        return opUserMapper.selectByPrimaryKey(id);
    }

    private static HashMap<String,Integer> groupVariable=new HashMap<String,Integer>();

    @Transactional
    @Override
    public JSONObject insertOrderData(JSONObject requestData,JSONObject result) throws Exception{
        String[] params = {"trade","name","idNo","mobile","plateLicense","carType","owner","useNature","brandModel","identifyCode","engineNumber","registDate","orderType","orderAmount","orderTime","insureCity","insureUser","insurant","channelName"};
        checkParam(requestData,params);

        String trade = requestData.getString("trade");

        /*------------------------用户信息----------------------------*/
        String name = requestData.getString("name");
        String idNo = requestData.getString("idNo");
        String mobile = requestData.getString("mobile");
        String idNoImage = requestData.get("idNoImage")==null?"":requestData.get("idNoImage").toString();

        /*------------------------车辆信息----------------------------*/
        String plateLicense = requestData.getString("plateLicense");
        String carType = requestData.getString("carType");
        String owner = requestData.getString("owner");
        String address = requestData.get("address")==null?"":requestData.get("address").toString();
        String useNature = requestData.getString("useNature");
        String brandModel = requestData.getString("brandModel");
        String identifyCode = requestData.getString("identifyCode");
        String engineNumber = requestData.getString("engineNumber");
        String registDate = requestData.getString("registDate");
        String certificateDate = requestData.get("certificateDate")==null?"":requestData.get("certificateDate").toString();
        String drivingLicenseImage = requestData.get("drivingLicenseImage")==null?"":requestData.get("drivingLicenseImage").toString();

        /*------------------------订单信息----------------------------*/
        String orderType = requestData.getString("orderType");
        BigDecimal orderAmount = requestData.getBigDecimal("orderAmount");
        String orderTime = requestData.getString("orderTime");
        String channelName = requestData.getString("channelName");

        /*------------------------保险信息----------------------------*/
        String insureCity = requestData.getString("insureCity");
        String insureUser = requestData.getString("insureUser");
        String insurant = requestData.getString("insurant");

        String orderId = channelName+ StringUtil.Getnum();

        OpUser opUser = new OpUser();
        opUser.setName(name);
        opUser.setIdNo(idNo);
        opUser.setMobile(mobile);
        opUser.setTrade(trade);
        opUser.setOrderId(orderId);
        opUser.setIdNoImage(idNoImage);

        OpCar opCar = new OpCar();
        opCar.setOrderId(orderId);
        opCar.setTrade(trade);
        opCar.setAddress(address);
        opCar.setBrandModel(brandModel);
        opCar.setCarType(carType);
        opCar.setCertificateDate(StringUtils.isEmpty(certificateDate)?null: DateUtil.getDate(certificateDate, DateEnum.DATE_SIMPLE));
        opCar.setDrivingLicenseImage(drivingLicenseImage);
        opCar.setEngineNumber(engineNumber);
        opCar.setIdentifyCode(identifyCode);
        opCar.setOwner(owner);
        opCar.setPlateLicense(plateLicense);
        opCar.setRegistDate(DateUtil.getDate(registDate,DateEnum.DATE_SIMPLE));
        opCar.setUseNature(useNature);


        OpInsurance opInsurance = new OpInsurance();
        opInsurance.setOrderId(orderId);
        opInsurance.setInsurant(insurant);
        opInsurance.setInsureCity(insureCity);
        opInsurance.setInsureUser(insureUser);
        opInsurance.setTrade(trade);

        OpFlow opFlow = new OpFlow();
        opFlow.setTrade(trade);
        //opFlow.setBusinessId();
        opFlow.setChannelName(channelName);
        opFlow.setFlowStatus(FlowStatusEnum.WAIT_ORDER.getStatus());
        opFlow.setOrderAmount(orderAmount);
        opFlow.setOrderId(orderId);
        opFlow.setOrderTime(DateUtil.getDate(orderTime,DateEnum.DATE_FORMAT));
        opFlow.setOrderType(Integer.valueOf(orderType));
        //opFlow.setProductName();

        OpOrder opOrder = new OpOrder();
        opOrder.setOrderId(orderId);
        //opOrder.setProductName();
        opOrder.setOrderType(Integer.valueOf(orderType));
        opOrder.setOrderTime(DateUtil.getDate(orderTime,DateEnum.DATE_FORMAT));
        //opOrder.setBusinessId();
        opOrder.setChannelName(channelName);
        opOrder.setOrderAmount(orderAmount);
        opOrder.setOrderStatus(OrderStatusEnum.ATTESTATION_ING.getStatus());

        OpFlow of = opFlowMapper.selectByFlowId(trade);
        if(null == of){
            opUserMapper.insert(opUser);
            opCarMapper.insert(opCar);
            opInsuranceMapper.insert(opInsurance);
            opFlowMapper.insert(opFlow);
            opOrderMapper.insert(opOrder);
        }else{
            Integer id = of.getId();
            opUser.setId(id);
            opCar.setId(id);
            opInsurance.setId(id);
            opFlow.setId(id);
            opOrder.setId(id);
            opUserMapper.updateByPrimaryKey(opUser);
            opCarMapper.updateByPrimaryKey(opCar);
            opInsuranceMapper.updateByPrimaryKey(opInsurance);
            opFlowMapper.updateByPrimaryKey(opFlow);
            opOrderMapper.updateByPrimaryKey(opOrder);
        }

        result.put("orderId",orderId);
        return result;
    }

    @Override
    public JSONObject getOrderData(JSONObject requestData, JSONObject result) throws Exception{
        Object trade = requestData.get("trade");
        if(null == trade){
            throw new Exception("trade参数不能为空！");
        }

        OpFlow opFlow = opFlowMapper.selectByFlowId(trade.toString());
        if(null == opFlow){
            throw new Exception("不存在对应的流水记录！");
        }

        String flowStatus = opFlow.getFlowStatus();
        if(!StringUtils.equals(FlowStatusEnum.HAS_ORDER.getStatus(),flowStatus)){
            result.put("OrderStatus","");
            result.put("OrderMsg", "");
            result.put("flowStatus",flowStatus);
            result.put("flowMsg",FlowStatusEnum.getMsg(flowStatus));
            return result;
        }

        Object orderId = requestData.get("orderId");
        if(null == trade){
            throw new Exception("orderId参数不能为空！");
        }

        OpOrder opOrder = opOrderMapper.selectByOrderId(orderId.toString());
        String orderStatus = opOrder.getOrderStatus();
        result.put("flowStatus",flowStatus);
        result.put("flowMsg",FlowStatusEnum.getMsg(flowStatus));
        result.put("OrderStatus",orderStatus);
        result.put("OrderMsg", OrderStatusEnum.getMsg(orderStatus));
        return result;
    }

    @Override
    public JSONObject noticeOutOrderData(JSONObject requestData, JSONObject result) throws Exception {
        String[] params = {"trade","orderId","idNo","outOrderStatus","orderAmountFinal"};
        checkParam(requestData,params);

        String orderId = requestData.getString("orderId");
        String outOrderStatus = requestData.getString("outOrderStatus");
        BigDecimal orderAmountFinal = requestData.getBigDecimal("orderAmountFinal");

        OpOrder opOrder = new OpOrder();
        opOrder.setOrderId(orderId);
        opOrder.setOrderStatus("27");
        opOrder.setOrderAmountFinal(orderAmountFinal);
        opOrderMapper.updateByOrderId(opOrder);


        Object busiOrderNumber = requestData.get("busiOrderNumber");
        Object ctaliOrderNumber = requestData.get("ctaliOrderNumber");
        OpInsurance opInsurance = new OpInsurance();
        opInsurance.setOrderId(orderId);
        opInsurance.setOutOrderStatus(outOrderStatus);
        if(StringUtils.equals("0",outOrderStatus)){
            String[] param0 = {"busiOrderNumber","busiAmount","ctaliOrderNumber","ctaliAmount"};
            checkParam(requestData,param0);
            opInsurance.setBusiAmount(requestData.getBigDecimal("busiAmount"));
            opInsurance.setBusiOrderNumber(busiOrderNumber.toString());
            opInsurance.setCtaliAmount(requestData.getBigDecimal("ctaliAmount"));
            opInsurance.setCtaliOrderNumber(ctaliOrderNumber.toString());
        }else if(StringUtils.equals("1",outOrderStatus)){
            String[] param1 = {"ctaliOrderNumber","ctaliAmount"};
            checkParam(requestData,param1);
            opInsurance.setCtaliAmount(requestData.getBigDecimal("ctaliAmount"));
            opInsurance.setCtaliOrderNumber(ctaliOrderNumber.toString());
        }else if(StringUtils.equals("2",outOrderStatus)){
            String[] param2 = {"busiOrderNumber","busiAmount"};
            checkParam(requestData,param2);
            opInsurance.setBusiAmount(requestData.getBigDecimal("busiAmount"));
            opInsurance.setBusiOrderNumber(busiOrderNumber.toString());
        }
        opInsuranceMapper.updateByOrderId(opInsurance);

        result.put("orderId",orderId);
        return result;
    }

    @Override
    public JSONObject queryTradeInfo(JSONObject requestData, JSONObject result) throws Exception {
        String[] params = {"trade","orderId","idNo"};
        checkParam(requestData,params);

        String orderId = requestData.getString("orderId");
        //待用户中心提供相应接口，此处为测试数据
        testTradeData(result);

        return result;
    }

    private void testTradeData(Map<String,Object> order){
        order.put("orderId","ZJ4526547225");
        order.put("createTime","2018-06-13 10:00:00");
        order.put("orderType","1");
        order.put("orderStatus","1");
        order.put("tradeStatus","1");
        order.put("tradeAmount",5000.00);
        order.put("term",6);
        order.put("principal",5000);
        order.put("rate",1.00);
        order.put("serviceFee",50.00);

        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("name","李静");
        userInfo.put("idNo","211411198804044567");
        userInfo.put("mobile","18888888888");

        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Map<String,Object> repaymentPlan = new HashMap<>();
            repaymentPlan.put("periods",i+"");
            repaymentPlan.put("reapyemntDate","2018-07-0"+i+" 00:00:00");
            repaymentPlan.put("principal",900.00);
            repaymentPlan.put("interest",10.00);
            list.add(repaymentPlan);
        }


        Map<String,Object> repayment = new HashMap<>();
        repayment.put("repaymentBank","ZJ4526547225");
        repayment.put("repaymentBankCardNo","ZJ4526547225");
        repayment.put("repaymentPlan",list);

        Map<String,Object> map = new HashMap<>();
        map.put("order",order);
        map.put("userInfo",userInfo);
        map.put("repayment",repayment);
    }

    private void checkParam(JSONObject requestData,String[] params) throws Exception{
        if(null == requestData){
            throw new Exception("请求数据不能为空！");
        }
        for (int i = 0; i < params.length; i++) {
            Object param = requestData.get(params[i]);
            if(null == param){
                throw new Exception(params[i]+"不能为空！");
            }
        }
    }

}
