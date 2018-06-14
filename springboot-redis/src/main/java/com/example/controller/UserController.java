package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @RequestMapping(value = "/add")
    public void addUser(User user){
        if (user != null) {
            userService.createUser(user);
        }
    }

    @RequestMapping(value = "/query")
    public void queryUser(User user){
        if (user != null) {
            userService.getUser(user.getId());
        }
    }

    @RequestMapping(value = "/update")
    public void updateUser(User user){
        if (user != null) {
            userService.updateUser(user);
        }
    }

    @RequestMapping(value = "/delete")
    public void deleteUser(User user){
        if (user != null) {
            userService.deleteUser(user.getId());
        }
    }
}
