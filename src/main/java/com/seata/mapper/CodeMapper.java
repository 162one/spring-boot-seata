package com.seata.mapper;

import com.seata.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wang_zhen
 * @Date 2023/10/19 12:00
 * @Description:
 */
public interface CodeMapper {

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    Code selectByPrimaryKey(@Param("id")Long id);

    /**
     * 保存信息
     *
     * @param code
     * @return 结果
     */
    void insertSelective(Code code);

    /**
     * 修改信息
     *
     * @param code
     * @return 结果
     */
    void updateByPrimaryKeySelective(Code code);

    /**
     * 删除
     *
     * @param id 需要删除的 ID
     * @return 结果
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);

    void batchInsert(List<Code> codes);
}
