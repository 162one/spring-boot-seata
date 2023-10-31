package com.seata.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface AccountService extends IService<Account> {
    Account getByUserId(Long userId);

    Account updateAccount(Order order, User seller, Integer type);
}

