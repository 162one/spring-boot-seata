package com.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.domain.AjaxResult;
import com.seata.entity.Order;
import com.seata.entity.Product;
import com.seata.entity.Storage;
import com.seata.service.OrderService;
import com.seata.service.ProductService;
import com.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 订单表管理
 *
 * @author wz
 * @email
 * @date 2023-10-27 15:37:33
 */
@RestController
@RequestMapping("/order")
@Tag(name = "order-controller", description = "订单表管理")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private ProductService productService;
    @Resource
    private StorageService storageService;
    @Resource
    private RedissonClient redisson;

    /**
     * 订单信息列表
     *
     * @return
     */
    @GetMapping("list")
    @ApiOperation("订单信息")
    public AjaxResult list(){
        List<Order> orders = orderService.list(new QueryWrapper<>());
        return AjaxResult.success(orders);
    }

    /**
     * 保存信息
     *
     * @param order
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存信息")
    @GlobalTransactional
    public AjaxResult save(@RequestBody @Validated Order order) {
        Random random = new Random();
        Long productId = Long.valueOf(random.nextInt(10) + 1);
        Long buyerId = Long.valueOf(random.nextInt(4) + 1) + 2;
        Long sellerId = storageService.getOne(new QueryWrapper<Storage>().eq("product_id", productId)).getCreateBy();
        order.setSellerId(sellerId);
        order.setBuyerId(buyerId);
        order.setProductId(productId);
        order.setProductName(productService.getById(productId).getName());
        String lockKey = order.getBuyerId() + "_" + order.getSellerId() + "_" + order.getProductId() + "";
        //获取锁资源
        RLock lock = redisson.getLock(lockKey);
        try {
            //加锁,可以指定锁定时间
            lock.lock(10, TimeUnit.SECONDS);
            orderService.saveOrder(order);
        } finally {
            //释放锁
            lock.unlock();
        }
        return AjaxResult.success();
    }

    /**
     * 订单信息
     *
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    @ApiOperation("订单信息")
    public AjaxResult info(@ApiParam(name = "id", value = "订单Id", required = true) @PathVariable Long id){

        return AjaxResult.success(orderService.getById(id));
    }
}
