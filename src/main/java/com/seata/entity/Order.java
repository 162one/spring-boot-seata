package com.seata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@Data
@ApiModel("信息")
public class Order implements Serializable {

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
    private Long productId;
	/**
	 *
	 */
    @ApiModelProperty("")
    private String productName;
	/**
	 *
	 */
	@ApiModelProperty("")
	private BigDecimal price;
	/**
	 *
	 */
	@ApiModelProperty("")
	private Integer quantity;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private BigDecimal money;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private Long sellerId;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private Long buyerId;
}
