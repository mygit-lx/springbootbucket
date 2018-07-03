package com.example.dao;

import com.example.domain.OpUser;

public interface OpUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpUser record);

    int insertSelective(OpUser record);

    OpUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpUser record);

    int updateByPrimaryKey(OpUser record);
}