package com.seata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {

    Account getByUserId(@Param("userId") Long userId);
}
