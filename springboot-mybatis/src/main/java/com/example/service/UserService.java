package com.example.service;

import com.example.dao.entity.User;
import com.example.dao.repository.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V3.0.0 2018年03月08日 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2015，2115,北京小马金融服务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    public User findById(Integer id){
        return userMapper.selectById(id);
    }

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user){
        userMapper.insert(user);
    }

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user){
        userMapper.updateById(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(Integer id){
        userMapper.deleteById(id);
    }

    /**
     * 查询所有用户
     * @param
     */
    public List<User> findAll(){
        return userMapper.findAll();
    }
}
