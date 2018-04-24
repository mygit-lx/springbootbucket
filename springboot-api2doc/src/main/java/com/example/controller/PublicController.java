package com.example.controller;

import com.example.model.*;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 机具管理API接口类
 */
@Api2Doc(id = "机具管理")
@ApiComment()
@RestController
@RequestMapping(value = "/api/v1")
public class PublicController {

    private static final Logger _logger = LoggerFactory.getLogger(PublicController.class);


    /**
     * 入网绑定查询接口
     *
     * @return 是否入网
     */
    @ApiComment("根据IMEI码来查询该POS机是否入网并绑定<br/>每次打开APP的时候需要调用这个接口来进行检查<br/>如果入网并且绑定了网点才能打开APP，否则必须调用入网或绑定网点接口成功后才能继续下一步")
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public JoinBindResponse join(@RequestHeader(name = "Accept",defaultValue = "application/json",required = false) String accpet,
                                 @RequestHeader(name = "Authorization",defaultValue = "token") String token,
                                 @RequestParam("imei") String imei){
        _logger.info("入网查询接口 start。。。");
        JoinBindResponse result = new JoinBindResponse();
        result.setSuccess(true);
        result.setCode(1);
        result.setMsg("已入网并绑定了网点");
        return result;
    }

    @ApiComment("通过收集POS硬件信息请求入网，另外还必须传入网点名称")
    @RequestMapping(value = "doJoin",method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> doJoin(
            @RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
            @RequestHeader(name="Authorization", defaultValue="token") String token,
            @RequestBody PosParam posParam){
        _logger.info("请求入网接口 start。。。");
        BaseResponse result = new BaseResponse();
        result.setSuccess(true);
        result.setMsg("入网成功");
        return new ResponseEntity<BaseResponse>(result, HttpStatus.CREATED);
    }

    /**
     * 请求绑定网点接口
     *
     * @return 处理结果
     */
    @ApiComment("POS机重新绑定新的网点")
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> doBind(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                               @RequestHeader(name="Authorization", defaultValue="token") String token,
                                               @RequestBody BindParam bindParam) {
        _logger.info("请求绑定网点接口 start....");
        BaseResponse result = new BaseResponse();
        result.setSuccess(true);
        result.setMsg("绑定网点成功");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 报告位置接口
     *
     * @return 报告结果
     */
    @ApiComment("终端设备定时报告位置信息")
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public BaseResponse report(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                               @RequestHeader(name="Authorization", defaultValue="token") String token,
                               @RequestBody ReportParam param) {
        _logger.info("定时报告接口 start....");
        BaseResponse result = new BaseResponse();
        result.setSuccess(true);
        result.setMsg("心跳报告成功");
        return result;
    }

    /**
     * 版本检查接口
     *
     * @return 版本检查结果
     */
    @ApiComment("APP版本更新检查")
    @RequestMapping(value = "/version", method = RequestMethod.POST)
    public VersionResult version(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                 @RequestHeader(name="Authorization", defaultValue="token") String token,
                                 @RequestBody VersionParam param) {
        _logger.info("版本检查接口 start....");
        VersionResult result = new VersionResult();
        result.setAppName("AppName");
        result.setDownloadUrl("http://www.baidu.com/");
        result.setFindNew(true);
        result.setPublishtime(new Date());
        result.setTips("tips");
        result.setVersion("v1.2");
        return result;
    }
}
