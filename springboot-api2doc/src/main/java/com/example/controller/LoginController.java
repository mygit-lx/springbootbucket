package com.example.controller;

import com.example.model.BaseResponse;
import com.example.model.LoginParam;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口类
 */
@Api2Doc(id = "登录")
@RestController
public class LoginController {

    private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);

    @ApiComment("不管是接口还是WebSocket连接都需要先调用此接口拿到Token，然后再通过Token调用相应接口，最好使用HTTPS协议。调用RESTful API方式不需要传后面两个参数，如果通过WebSocket连接需要传递")
    @PostMapping("/login")
    public BaseResponse<String> login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                      @ApiComment(value = "登录参数") @RequestBody LoginParam loginParam) {
        _logger.info("用户请求登录获取Token");
        return new BaseResponse<>(true, "Login success", "JWT");
    }

    @ApiComment("这里的密码是加密后的密码")
    @PostMapping("/notifyLogin")
    public BaseResponse<String> notifyLogin(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                            @ApiComment(value = "登录参数") @RequestBody LoginParam loginParam) {
        _logger.info("登录用户推送请求登录获取Token");
        return new BaseResponse<>(true, "Login success", "JWT");
    }

    @GetMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponse unauthorized() {
        return new BaseResponse<>(false, "Unauthorized", null);
    }

}
