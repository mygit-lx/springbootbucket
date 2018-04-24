package com.example.service.impl;

import com.example.dao.UserInfoMapper;
import com.example.entity.UserInfo;
import com.example.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoMapper.findAllUserInfo();
    }

}
