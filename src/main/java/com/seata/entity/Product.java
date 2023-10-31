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
 * 产品表
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:39:07
 */
@Data
@Schema
@TableName("t_product")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *	主键
	 */
    @TableId
    @Schema(description = "主键")
    private Long id;
	/**
	 *	产品名称
	 */
    @Schema(description = "产品名称")
    private String name;
	/**
	 *	单价
	 */
    @Schema(description = "单价")
    private BigDecimal price;
	/**
	 *	状态 0：禁用 1：启用
	 */
    @Schema(description = "状态 0：禁用 1：启用")
    private Integer status;
	/**
	 *	创建人ID
	 */
    @Schema(description = "创建人ID")
    private Long createBy;
	/**
	 *	创建人名称
	 */
    @Schema(description = "创建人名称")
    private String createName;
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
