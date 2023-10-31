package com.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.entity.Order;
import com.seata.entity.Storage;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface OrderService extends IService<Order> {

    /**
     * 保存订单信息
     *
     * @param order
     */
    void saveOrder(Order order);
}

