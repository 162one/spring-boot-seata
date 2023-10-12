package com.seata.controller;

import com.seata.entity.User;
import com.seata.service.UserService;
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
@RequestMapping("/user")
@Api(tags = "管理")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public User info(@ApiParam(name = "id", value = "Id", required = true) @PathVariable Long id){

        User user = userService.info(id);
        return user;
    }

    /**
     * 保存信息
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存信息")
    public void save(@RequestBody @Validated User user){

        userService.insert(user);
    }

    /**
     * 修改信息
     */
    @PostMapping("/update")
    @ApiOperation("修改信息")
    public void update(@RequestBody @Validated User user){

        userService.update(user);
    }

    /**
     * 删除信息
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("删除信息")
    public void delete(@ApiParam(name = "id", value = "Id", required = true) @PathVariable Long id){

        userService.deleteById(id);
    }
}
