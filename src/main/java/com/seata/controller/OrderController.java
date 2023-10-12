package com.seata.controller;

import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;
import com.seata.service.AccountService;
import com.seata.service.OrderService;
import com.seata.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@RestController
@RequestMapping("/order")
@Api(tags = "管理")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private AccountService accountService;
    @Resource
    private UserService userService;

    /**
     * 保存信息
     *
     * @param order
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存信息")
    @GlobalTransactional
    public void save(@RequestBody @Validated Order order){
//        User seller = userService.getById(order.getSellerId());
//        User buyer = userService.getById(order.getBuyerId());
//
//        Account sellerAccount = accountService.updateAccount(order, seller, 1);
//        Account buyerAccount = accountService.updateAccount(order, buyer, 2);
//        orderService.insert(order);
//        int a = 1 / 0;
        orderService.save(order);
    }

    /**
     * 订单信息
     *
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    @ApiOperation("订单信息")
    public Order info(@ApiParam(name = "id", value = "费用明细Id", required = true) @PathVariable Long id){

        return orderService.info(id);
    }
}
