package com.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.domain.AjaxResult;
import com.seata.entity.Product;
import com.seata.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 产品表管理
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:39:07
 */
@RestController
@RequestMapping("/product")
@Tag(name = "product-controller", description = "产品表管理")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 产品表信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "产品表信息")
    public AjaxResult<Product> info(@Parameter(description = "ID") @PathVariable Long id){

        Product product = productService.getOne(
                new QueryWrapper<Product>()
                        .eq("del_flag", 0)
                        .eq("id", id));
        return AjaxResult.success(product);
    }

    /**
     * 保存产品表信息
     *
     * @param product
     * @return
     */
    @PostMapping
    @Operation(summary = "保存产品表列表")
    public AjaxResult save(@RequestBody Product product){

        productService.save(product);
        return AjaxResult.success();
    }

    /**
     * 修改产品表信息
     *
     * @param product
     */
    @PutMapping
    @Operation(summary = "修改产品表列表")
    public AjaxResult update(@RequestBody Product product){

        productService.updateById(product);
        return AjaxResult.success();
    }
}
