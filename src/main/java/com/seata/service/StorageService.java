package com.seata.service;


import com.seata.entity.Storage;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
public interface StorageService {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Storage info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Storage getById(Long id);

    Storage getByProductId(Long productId);

    /**
     * 保存信息
     *
     * @param storage
     * @return 结果
     */
    void insert(Storage storage);

    /**
     * 修改信息
     *
     * @param storage
     * @return 结果
     */
    void update(Storage storage);

    /**
     * 修改信息
     *
     * @param storage
     * @return 结果
     */
    void updateById(Storage storage);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);
}

