package com.seata.controller;

import com.seata.entity.Order;
import com.seata.service.OrderService;
import com.seata.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    private ProductService productService;
    @Resource
    private RedissonClient redisson;

    /**
     * 保存信息
     *
     * @param order
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存信息")
    @GlobalTransactional
    public void save(@RequestBody @Validated Order order) {
        Random random = new Random();
        Long productId = Long.valueOf(random.nextInt(5) + 1);
        Long buyerId = Long.valueOf(random.nextInt(4) + 1);
        order.setBuyerId(buyerId);
        order.setProductId(productId);
        order.setProductName(productService.getById(productId).getName());
        String lockKey = order.getBuyerId() + "_" + order.getSellerId() + "_" + order.getProductId() + "";
        //获取锁资源
        RLock lock = redisson.getLock(lockKey);
        try {
            //加锁,可以指定锁定时间
            lock.lock(10, TimeUnit.SECONDS);
            orderService.save(order);
        } finally {
            //释放锁
            lock.unlock();
        }
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
