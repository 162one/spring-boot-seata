package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.Storage;
import com.seata.mapper.StorageMapper;
import com.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
@Service
@Slf4j
@DS("storage")
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Storage info(Long id) {

        log.info("StorageFacadeImpl.info:入参：id:{}", id);
        Storage storage = storageMapper.selectByPrimaryKey(id);
        return storage;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Storage getById(Long id) {

        log.info("StorageFacadeImpl.getById:入参：id:{}", id);
        return storageMapper.selectByPrimaryKey(id);
    }

    @Override
    public Storage getByProductId(Long productId) {

        log.info("StorageFacadeImpl.getByProductId:入参：id:{}", productId);
        return storageMapper.getByProductId(productId);
    }

    /**
     * 保存信息
     *
     * @param storage
     * @return 结果
     */
    @Override
    public void insert(Storage storage) {

        log.info("StorageFacadeImpl.insert:入参：storage:{}", JSON.toJSON(storage));
        storageMapper.insertSelective(storage);
    }

    /**
     * 修改信息
     *
     * @param storage
     * @return 结果
     */
    @Override
    public void update(Storage storage) {
        log.info("StorageFacadeImpl.update:入参：storage:{}", JSON.toJSON(storage));
        storageMapper.updateByPrimaryKeySelective(storage);
    }

    /**
     * 修改信息
     *
     * @param storage
     * @return 结果
     */
    @Override
    public void updateById(Storage storage) {
        log.info("StorageFacadeImpl.updateById:入参：storage:{}", JSON.toJSON(storage));
        storageMapper.updateByPrimaryKeySelective(storage);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("StorageFacadeImpl.deleteById:入参：id:{}", id);
        storageMapper.deleteByPrimaryKey(id);
    }

}
