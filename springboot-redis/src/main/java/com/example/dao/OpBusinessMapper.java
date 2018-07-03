package com.example.dao;

import com.example.domain.OpBusiness;

public interface OpBusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpBusiness record);

    int insertSelective(OpBusiness record);

    OpBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpBusiness record);

    int updateByPrimaryKey(OpBusiness record);
}