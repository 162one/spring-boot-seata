package com.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.domain.AjaxResult;
import com.seata.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.seata.entity.User;

/**
 * 用户表管理
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:40:10
 */
@RestController
@RequestMapping("/user")
@Tag(name = "user-controller", description = "用户表管理")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户表信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "用户表信息")
    public AjaxResult<User> info(@Parameter(description = "ID") @PathVariable Long id){

        User user = userService.getById(id);
        return AjaxResult.success(user);
    }

    /**
     * 保存用户表信息
     *
     * @param user
     * @return
     */
    @PostMapping
    @Operation(summary = "保存用户表列表")
    public AjaxResult save(@RequestBody User user){

        userService.save(user);
        return AjaxResult.success();
    }

    /**
     * 修改用户表信息
     *
     * @param user
     */
    @PutMapping
    @Operation(summary = "修改用户表列表")
    public AjaxResult update(@RequestBody User user){

        userService.updateById(user);
        return AjaxResult.success();
    }
}
