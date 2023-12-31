package com.seata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 
 *
 * @author wz
 * @email 
 * @date 2023-09-28 15:12:29
 */
@Data
@ApiModel("信息")
@NoArgsConstructor
@AllArgsConstructor
public class Code implements Serializable {

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
    private Integer type;
	/**
	 *	
	 */
    @ApiModelProperty("")
    private String code;
}
