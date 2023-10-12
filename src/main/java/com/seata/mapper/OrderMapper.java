package com.seata.mapper;


import com.seata.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
public interface OrderMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Order selectByPrimaryKey(@Param("id")Long id);

    /**
     * 保存信息
     *
     * @param order
     * @return 结果
     */
    void insertSelective(Order order);

    /**
     * 修改信息
     *
     * @param order
     * @return 结果
     */
    void updateByPrimaryKeySelective(Order order);

    /**
     * 删除 
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);
}
