package com.seata.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.entity.Storage;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
public interface StorageService extends IService<Storage> {
    Storage getByProductId(Long productId);
}

