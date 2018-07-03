package com.example.dao;

import com.example.domain.OpOrder;

public interface OpOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpOrder record);

    int insertSelective(OpOrder record);

    OpOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpOrder record);

    int updateByPrimaryKey(OpOrder record);

    OpOrder selectByOrderId(String s);

    boolean updateByOrderId(OpOrder record);
}