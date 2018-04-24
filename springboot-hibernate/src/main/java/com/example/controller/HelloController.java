package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V3.0.0 2018年03月05日 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2015，2115,北京小马金融服务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/say")
    public String hello(){
        return "Hello World!";
    }
}
