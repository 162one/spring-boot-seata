package com.seata.mapper;


import com.seata.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
public interface AccountMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Account selectByPrimaryKey(@Param("id")Long id);

    /**
     * 保存信息
     *
     * @param account
     * @return 结果
     */
    void insertSelective(Account account);

    /**
     * 修改信息
     *
     * @param account
     * @return 结果
     */
    void updateByPrimaryKeySelective(Account account);

    /**
     * 删除 
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);

    Account getByUserId(@Param("userId") Long userId);
}
