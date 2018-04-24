package com.example.dao.repository;

import com.example.common.repository.ManagerMapper;
import com.example.dao.entity.ManagerInfo;

/**
 * Description  :
 */
public interface ManagerInfoDao extends ManagerMapper {
    ManagerInfo findByUsername(String username);
}
