package com.seata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-10-13 15:34:55
 */
@Data
@ApiModel("信息")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *	
	 */
    @ApiModelProperty("")
    private Long id;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private String name;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private BigDecimal price;
}
