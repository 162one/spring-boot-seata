package com.seata.mapper;


import com.seata.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
public interface UserMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    User selectByPrimaryKey(@Param("id")Long id);

    /**
     * 保存信息
     *
     * @param user
     * @return 结果
     */
    void insertSelective(User user);

    /**
     * 修改信息
     *
     * @param user
     * @return 结果
     */
    void updateByPrimaryKeySelective(User user);

    /**
     * 删除 
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);
}
