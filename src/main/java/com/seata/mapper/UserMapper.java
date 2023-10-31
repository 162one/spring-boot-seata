package com.seata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
