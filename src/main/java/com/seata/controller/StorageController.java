package com.seata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.domain.AjaxResult;
import com.seata.entity.Storage;
import com.seata.service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 产品库存表管理
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:39:07
 */
@RestController
@RequestMapping("/storage")
@Tag(name = "storage-controller", description = "产品库存表管理")
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 产品库存表信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "产品库存表信息")
    public AjaxResult<Storage> info(@Parameter(description = "ID") @PathVariable Long id){

        Storage storage = storageService.getOne(
                new QueryWrapper<Storage>()
                        .eq("del_flag", 0)
                        .eq("id", id));
        return AjaxResult.success(storage);
    }

    /**
     * 保存产品库存表信息
     *
     * @param storage
     * @return
     */
    @PostMapping
    @Operation(summary = "保存产品库存表列表")
    public AjaxResult save(@RequestBody Storage storage){

        storageService.save(storage);
        return AjaxResult.success();
    }

    /**
     * 修改产品库存表信息
     *
     * @param storage
     */
    @PutMapping
    @Operation(summary = "修改产品库存表列表")
    public AjaxResult update(@RequestBody Storage storage){

        storageService.updateById(storage);
        return AjaxResult.success();
    }
}
