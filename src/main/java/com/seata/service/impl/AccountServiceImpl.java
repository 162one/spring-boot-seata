package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;
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
@Service
@Slf4j
@DS("user")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Account info(Long id) {

        log.info("AccountFacadeImpl.info:入参：id:{}", id);
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Account getById(Long id) {

        log.info("AccountFacadeImpl.getById:入参：id:{}", id);
        return accountMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存信息
     *
     * @param account
     * @return 结果
     */
    @Override
    public void insert(Account account) {

        log.info("AccountFacadeImpl.insert:入参：account:{}", JSON.toJSON(account));
        accountMapper.insertSelective(account);
    }

    /**
     * 修改信息
     *
     * @param account
     * @return 结果
     */
    @Override
    public void update(Account account) {
        log.info("AccountFacadeImpl.update:入参：account:{}", JSON.toJSON(account));
        accountMapper.updateByPrimaryKeySelective(account);
    }

    /**
     * 修改信息
     *
     * @param account
     * @return 结果
     */
    @Override
    public void updateById(Account account) {
        log.info("AccountFacadeImpl.updateById:入参：account:{}", JSON.toJSON(account));
        accountMapper.updateByPrimaryKeySelective(account);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("AccountFacadeImpl.deleteById:入参：id:{}", id);
        accountMapper.deleteByPrimaryKey(id);
    }

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
                log.error(user.getUsername() + "余额不足！");
                int a = 1 / 0;
            }
            account.setMoney(money);
        }
        if (account.getId() == null) {
            insert(account);
        } else {
            updateById(account);
        }
        return account;
    }
}
