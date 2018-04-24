package com.example.dao;


import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoDao {

    @Select("SELECT * FROM user_info")
    @Results({
            @Result(property = "sex",column = "sex"),
            @Result(property = "education",column = "education"),
            @Result(property = "borrowerName",column = "borrower_name"),
            @Result(property = "homeAdress",column = "home_adress"),
            @Result(property = "maritalStatus",column = "marital_status"),
            @Result(property = "creatTime",column = "creat_time")
    })
    List<UserInfo> findAllUserInfo();
}
