package com.example.dao.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.dao.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 这个接口继承 BaseMapper<User>后即可获得常用的增删改查的方法， 如果有其他复杂的操作，就再定义自己的方法，并同时定义mapping文件即可。
 * Created by luox on 2018/3/8.
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM t_user;")
    List<User> findAll();
}
