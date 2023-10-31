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
import java.util.Date;


/**
 * 用户表
 *
 * @author wz
 * @email 
 * @date 2023-10-27 15:40:10
 */
@Data
@Schema
@TableName("t_user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *	主键
	 */
    @TableId
    @Schema(description = "主键")
    private Long id;
	/**
	 *	用户名称
	 */
    @Schema(description = "用户名称")
    private String username;
	/**
	 *	年龄
	 */
    @Schema(description = "年龄")
    private Integer age;
	/**
	 *	类型：1：买家；2：卖家
	 */
    @Schema(description = "类型：1：买家；2：卖家")
    private Integer type;
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
