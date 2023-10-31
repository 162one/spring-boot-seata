package com.seata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:37:33
 */
@Data
@Schema
@TableName("t_order")
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *	主键
	 */
    @TableId
    @Schema(description = "主键")
    private Long id;
	/**
	 *	产品Id
	 */
    @Schema(description = "产品Id")
    private Long productId;
	/**
	 *	产品名称
	 */
    @Schema(description = "产品名称")
    private String productName;
	/**
	 *	数量
	 */
    @Schema(description = "数量")
    private Integer quantity;
	/**
	 *	单价
	 */
    @Schema(description = "单价")
    private BigDecimal price;
	/**
	 *	总价
	 */
    @Schema(description = "总价")
    private BigDecimal money;
	/**
	 *	卖家
	 */
    @Schema(description = "卖家")
    private Long sellerId;
	/**
	 *	买家
	 */
    @Schema(description = "买家")
    private Long buyerId;
	/**
	 *	状态 0：禁用 1：启用
	 */
    @Schema(description = "状态 0：禁用 1：启用")
    private Integer status;
	/**
	 *	创建时间
	 */
    @Schema(description = "创建时间")
    private Date createTime;
	/**
	 *	修改时间
	 */
    @Schema(description = "修改时间")
    private Date updateTime;
}
