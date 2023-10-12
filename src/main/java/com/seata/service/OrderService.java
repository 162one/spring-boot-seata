package com.seata.service;

import com.seata.entity.Order;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface OrderService {


    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Order info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Order getById(Long id);

    /**
     * 保存信息
     *
     * @param order
     * @return 结果
     */
    void insert(Order order);


    /**
     * 保存信息
     *
     * @param order
     * @return 结果
     */
    void save(Order order);

    /**
     * 修改信息
     *
     * @param order
     * @return 结果
     */
    void update(Order order);

    /**
     * 修改信息
     *
     * @param order
     * @return 结果
     */
    void updateById(Order order);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);
}

