package com.seata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
