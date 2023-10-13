package com.seata.service;


import com.seata.entity.Product;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
public interface ProductService {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Product info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Product getById(Long id);

    /**
     * 保存信息
     *
     * @param product
     * @return 结果
     */
    void insert(Product product);

    /**
     * 修改信息
     *
     * @param product
     * @return 结果
     */
    void update(Product product);

    /**
     * 修改信息
     *
     * @param product
     * @return 结果
     */
    void updateById(Product product);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);
}

