package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.entity.Account;
import com.seata.entity.User;
import com.seata.mapper.AccountMapper;
import com.seata.mapper.UserMapper;
import com.seata.service.AccountService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;



}
