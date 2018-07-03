package com.example.dao;

import com.example.domain.OpInsurance;

public interface OpInsuranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpInsurance record);

    int insertSelective(OpInsurance record);

    OpInsurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpInsurance record);

    int updateByPrimaryKey(OpInsurance record);

    int updateByOrderId(OpInsurance opInsurance);
}