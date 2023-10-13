package com.seata.controller;

import com.seata.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理
 *
 * @author wz
 * @email 
 * @date 2023-10-13 15:34:55
 */
@RestController
@RequestMapping("/product")
@Api(tags = "管理")
public class ProductController {

    @Resource
    private ProductService productService;
}
