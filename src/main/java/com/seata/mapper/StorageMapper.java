package com.seata.mapper;


import com.seata.entity.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-10-13 15:34:55
 */
public interface StorageMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Storage selectByPrimaryKey(@Param("id")Long id);

    Storage getByProductId(Long productId);

    /**
     * 保存信息
     *
     * @param storage
     * @return 结果
     */
    void insertSelective(Storage storage);

    /**
     * 修改信息
     *
     * @param storage
     * @return 结果
     */
    void updateByPrimaryKeySelective(Storage storage);

    /**
     * 删除
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);
}
