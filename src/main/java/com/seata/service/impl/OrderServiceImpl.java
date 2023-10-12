package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;
import com.seata.mapper.OrderMapper;
import com.seata.service.AccountService;
import com.seata.service.OrderService;
import com.seata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wz
 * @date 2023-09-28 15:12:29
 */
@Service
@Slf4j
@DS("order")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private UserService userService;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Order info(Long id) {

        log.info("OrderFacadeImpl.info:入参：id:{}", id);
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Order getById(Long id) {

        log.info("OrderFacadeImpl.getById:入参：id:{}", id);
        return orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存信息
     *
     * @param order
     * @return 结果
     */
    @Override
    public void save(Order order) {

        log.info("OrderFacadeImpl.insert:入参：order:{}", JSON.toJSON(order));
        User seller = userService.getById(order.getSellerId());
        User buyer = userService.getById(order.getBuyerId());

        Account sellerAccount = accountService.updateAccount(order, seller, 1);
        Account buyerAccount = accountService.updateAccount(order, buyer, 2);
        insert(order);
        int a = 1 / 0;
    }
    /**
     * 保存信息
     *
     * @param order
     * @return 结果
     */
    @Override
    public void insert(Order order) {

        log.info("OrderFacadeImpl.insert:入参：order:{}", JSON.toJSON(order));
        orderMapper.insertSelective(order);
    }

    /**
     * 修改信息
     *
     * @param order
     * @return 结果
     */
    @Override
    public void update(Order order) {
        log.info("OrderFacadeImpl.update:入参：order:{}", JSON.toJSON(order));
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 修改信息
     *
     * @param order
     * @return 结果
     */
    @Override
    public void updateById(Order order) {
        log.info("OrderFacadeImpl.updateById:入参：order:{}", JSON.toJSON(order));
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("OrderFacadeImpl.deleteById:入参：id:{}", id);
        orderMapper.deleteByPrimaryKey(id);
    }
}
