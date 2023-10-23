package com.seata.service;

import com.seata.entity.Code;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
public interface CodeService {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Code info(Long id);

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Code getById(Long id);

    /**
     * 保存信息
     *
     * @param code
     * @return 结果
     */
    void insert(Code code);

    /**
     * 修改信息
     *
     * @param code
     * @return 结果
     */
    void update(Code code);

    /**
     * 修改信息
     *
     * @param code
     * @return 结果
     */
    void updateById(Code code);

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    void deleteById(Long id);
}

