package com.example.common.config;

import com.example.domain.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//线程池中工作的线程
@Component
@Scope("prototype")//spring 多例
public class DBThread implements Runnable {
    private String msg;
    private Logger log = LoggerFactory.getLogger(DBThread.class);

    @Autowired
    private UserService userService;



    @Override
    public void run() {
        //模拟在数据库插入数据
        User user = new User();
        user.setPassword("1qaz");
        user.setUsername("test01");
        userService.createUser(user);
        log.info("insert->" + msg);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
