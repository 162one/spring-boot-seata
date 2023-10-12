package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.User;
import com.seata.mapper.UserMapper;
import com.seata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
@Service
@Slf4j
@DS("user")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public User info(Long id) {

        log.info("UserFacadeImpl.info:入参：id:{}", id);
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public User getById(Long id) {

        log.info("UserFacadeImpl.getById:入参：id:{}", id);
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存信息
     *
     * @param user
     * @return 结果
     */
    @Override
    public void insert(User user) {

        log.info("UserFacadeImpl.insert:入参：user:{}", JSON.toJSON(user));
        userMapper.insertSelective(user);
    }

    /**
     * 修改信息
     *
     * @param user
     * @return 结果
     */
    @Override
    public void update(User user) {
        log.info("UserFacadeImpl.update:入参：user:{}", JSON.toJSON(user));

        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 修改信息
     *
     * @param user
     * @return 结果
     */
    @Override
    public void updateById(User user) {
        log.info("UserFacadeImpl.updateById:入参：user:{}", JSON.toJSON(user));
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("UserFacadeImpl.deleteById:入参：id:{}", id);
        userMapper.deleteByPrimaryKey(id);
    }

}
