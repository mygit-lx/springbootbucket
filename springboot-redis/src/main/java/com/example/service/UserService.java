package com.example.service;


import com.example.dao.UserMapper;
import com.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 创建用户
     * 不会对缓存做任何操作
     * @param user
     */
    public void createUser(User user){
        logger.info("创建用户start...");
        userMapper.insert(user);
    };

    /**
     * 获取用户信息
     * 如果缓存存在，则从缓存中获取
     * 如果缓存中不存在，则从数据库中获取
     * @param id
     * @return
     */
    public User getUser(int id){
        logger.info("获取用户start...");
        //从缓存中获取用户信息
        String key = "U"+id;

        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = (User) redisTemplate.opsForValue().get(key);
            logger.info("从缓存中获取的用户id={}",id);
            return user;
        }

        //缓存中不存在，则从数据库中获取
        User user = userMapper.selectById(id);
        //插入缓存
        redisTemplate.opsForValue().set(key,user,1, TimeUnit.MINUTES);

        return user;
    }

    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     * @param user
     */
    public void updateUser(User user){
        logger.info("更新用户start...");
        userMapper.updateById(user);
        Integer id = user.getId();
        //缓存存在则删除缓存
        String key = "U"+id;
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时候，从缓存中删除用户>>{}",id);
        }
    }

    /**
     * 删除用户
     * 如果　缓存中存在，删除
     * @param id
     */
    public void deleteUser(int id){
        logger.info("删除用户start...");
        userMapper.deleteById(id);

        //缓存存在。删除缓存
        String key = "U"+id;
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户的时候，从缓存中删除用户>>｛｝",id);
        }

    }
}
