package com.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.domain.AjaxResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import com.seata.entity.Account;
import com.seata.service.AccountService;

/**
 * 账户表管理
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:40:10
 */
@RestController
@RequestMapping("/account")
@Tag(name = "account-controller", description = "账户表管理")
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 账户表信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "账户表信息")
    public AjaxResult<Account> info(@Parameter(description = "ID") @PathVariable Long id){

        Account account = accountService.getOne(
                new QueryWrapper<Account>()
                        .eq("id", id));
        return AjaxResult.success(account);
    }

    /**
     * 保存账户表信息
     *
     * @param account
     * @return
     */
    @PostMapping
    @Operation(summary = "保存账户表列表")
    public AjaxResult save(@RequestBody Account account){

        accountService.save(account);
        return AjaxResult.success();
    }

    /**
     * 修改账户表信息
     *
     * @param account
     */
    @PutMapping
    @Operation(summary = "修改账户表列表")
    public AjaxResult update(@RequestBody Account account){

        accountService.updateById(account);
        return AjaxResult.success();
    }
}
