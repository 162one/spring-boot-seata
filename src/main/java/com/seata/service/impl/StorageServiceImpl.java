package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.entity.Storage;
import com.seata.mapper.StorageMapper;
import com.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
@Service
@Slf4j
@DS("storage")
@Transactional
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public Storage getByProductId(Long productId) {
        Storage storage = getOne(
                new QueryWrapper<Storage>()
                        .eq("product_id", productId));
        return storage;
    }
}
