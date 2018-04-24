package com.example.controller;

import com.example.model.BaseResponse;
import com.example.model.UnbindParam;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 通知接口类
 */
@Api2Doc(id = "通知")
@ApiComment()
@RestController
@RequestMapping(value = "/notify")
public class NotifyController {

    private static final Logger _logger = LoggerFactory.getLogger(NotifyController.class);

    @ApiComment("后台管理员解除网点绑定后需调用此接口通知相应的POS机")
    @PostMapping("/unbind")
    public BaseResponse unbind(@RequestHeader(name = "Content-Type", defaultValue = "application/json") String contentType,
                               @RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               @RequestBody UnbindParam unbindParam) {
        _logger.info("解绑通知接口start");
        return new BaseResponse<>(true, "解绑通知发送成功", null);
    }
}
