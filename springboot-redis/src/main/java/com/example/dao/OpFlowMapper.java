package com.example.dao;

import com.example.domain.OpFlow;

public interface OpFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpFlow record);

    int insertSelective(OpFlow record);

    OpFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpFlow record);

    int updateByPrimaryKey(OpFlow record);

    OpFlow selectByFlowId(String trade);
}