package com.example.dao;

import com.example.domain.OpCar;

public interface OpCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpCar record);

    int insertSelective(OpCar record);

    OpCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpCar record);

    int updateByPrimaryKey(OpCar record);
}