package com.seata.service;


import com.seata.entity.Account;
import com.seata.entity.Order;
import com.seata.entity.User;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface AccountService {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Account info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Account getById(Long id);

    /**
     * 保存信息
     *
     * @param account
     * @return 结果
     */
    void insert(Account account);

    /**
     * 修改信息
     *
     * @param account
     * @return 结果
     */
    void update(Account account);

    /**
     * 修改信息
     *
     * @param account
     * @return 结果
     */
    void updateById(Account account);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);

    Account getByUserId(Long userId);

    Account updateAccount(Order order, User seller, Integer type);
}

