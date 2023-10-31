package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;
import com.seata.exception.BizException;
import com.seata.exception.ExceptionEnum;
import com.seata.mapper.AccountMapper;
import com.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
@Slf4j
@DS("user")
@Transactional
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getByUserId(Long userId) {
        return accountMapper.getByUserId(userId);
    }

    @Override
    public Account updateAccount(Order order, User user, Integer type) {
        log.info("AccountServiceImpl.updateAccount:order:{},user:{},type:{}", JSON.toJSON(order), JSON.toJSON(user), type);
        Account account = getByUserId(user.getId());
        if (account == null) {
            account = new Account();
        }
        account.setUserId(user.getId());
        //seller 卖家
        if (type == 1) {
            account.setMoney(account.getMoney().add(order.getMoney()));
        } else {
            //买家
            BigDecimal money = account.getMoney().subtract(order.getMoney());
            if (money.compareTo(BigDecimal.ZERO) < 0) {
                throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, user.getUsername() + "余额不足！");
            }
            account.setMoney(money);
        }
        if (account.getId() == null) {
            save(account);
        } else {
            updateById(account);
        }
        return account;
    }
}
