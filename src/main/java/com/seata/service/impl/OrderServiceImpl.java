package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.entity.*;
import com.seata.exception.BizException;
import com.seata.exception.ExceptionEnum;
import com.seata.mapper.OrderMapper;
import com.seata.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wz
 * @date 2023-09-28 15:12:29
 */
@Service
@Slf4j
@DS("order")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private UserService userService;
    @Resource
    private ProductService productService;
    @Resource
    private StorageService storageService;

    /**
     * 保存订单信息
     *
     * @param order
     * @return 结果
     */
    @Override
    public void saveOrder(Order order) {

        log.info("OrderFacadeImpl.insert:入参：order:{}", JSON.toJSON(order));
//        Long num = null;
//        num.toString();
        User seller = userService.getById(order.getSellerId());
        User buyer = userService.getById(order.getBuyerId());

        Product product = productService.getById(order.getProductId());
        Storage storage = storageService.getByProductId(order.getProductId());
        order.setProductName(product.getName());
        order.setPrice(product.getPrice());
        order.setMoney(product.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
        Integer quantity = storage.getQuantity() - order.getQuantity();
        if (quantity < 0) {
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, order.getProductName() + "库存不足！");
        }
        storage.setQuantity(quantity);
        storageService.updateById(storage);
        Account sellerAccount = accountService.updateAccount(order, seller, 1);
        Account buyerAccount = accountService.updateAccount(order, buyer, 2);
        save(order);
    }
}
