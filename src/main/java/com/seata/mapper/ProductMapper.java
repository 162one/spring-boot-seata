package com.seata.mapper;


import com.seata.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-10-13 15:34:55
 */
public interface ProductMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Product selectByPrimaryKey(@Param("id")Long id);

    /**
     * 保存信息
     *
     * @param product
     * @return 结果
     */
    void insertSelective(Product product);

    /**
     * 修改信息
     *
     * @param product
     * @return 结果
     */
    void updateByPrimaryKeySelective(Product product);

    /**
     * 删除 
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);
}
