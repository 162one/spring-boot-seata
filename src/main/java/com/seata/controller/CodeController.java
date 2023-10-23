package com.seata.controller;

import com.seata.entity.Account;
import com.seata.entity.Code;
import com.seata.service.AccountService;
import com.seata.service.CodeService;
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
@RequestMapping("/code")
@Api(tags = "管理")
public class CodeController {

    @Resource
    private AccountService accountService;
    @Resource
    private CodeService codeService;

    /**
     * 信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public Account info(@ApiParam(name = "id", value = "Id", required = true) @PathVariable Long id){

        Account account = accountService.info(id);
        return account;
    }

    /**
     * 保存信息
     *
     * @param account
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存信息")
    public void save(@RequestBody @Validated Account account){

        codeService.insert(new Code());
    }

    /**
     * 修改信息
     */
    @PostMapping("/update")
    @ApiOperation("修改信息")
    public void update(@RequestBody @Validated Account account){

        accountService.update(account);
    }

    /**
     * 删除信息
     */
    @PostMapping("/delete/{id}")
    @ApiOperation("删除信息")
    public void delete(@ApiParam(name = "id", value = "Id", required = true) @PathVariable Long id){

        accountService.deleteById(id);
    }
}