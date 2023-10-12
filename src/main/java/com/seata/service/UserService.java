package com.seata.service;

import com.seata.entity.User;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface UserService {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    User info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    User getById(Long id);

    /**
     * 保存信息
     *
     * @param user
     * @return 结果
     */
    void insert(User user);

    /**
     * 修改信息
     *
     * @param user
     * @return 结果
     */
    void update(User user);

    /**
     * 修改信息
     *
     * @param user
     * @return 结果
     */
    void updateById(User user);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);

}

