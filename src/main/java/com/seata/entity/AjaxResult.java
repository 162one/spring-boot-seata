package com.seata.entity;

import com.alibaba.fastjson.JSONObject;
import com.seata.exception.ExceptionEnum;
import lombok.Data;

/**
 * 平台响应基础模型
 * @param <T>
 */
@Data
//@Schema(description = "平台响应基础模型")
public class AjaxResult<T> {

    private static final long serialVersionUID = 6554368114187277861L;

    /**
     * 响应码
     */
    //@Schema(description = "响应码")
    private String code;
    /**
     * 响应描述
     */
    //@Schema(description = "响应描述")
    private String msg;
    /**
     * 响应业务结果
     */
    //@Schema(description = "响应业务结果")
    private T data;

    public static <T> AjaxResult<T> success() {
        AjaxResult<T> ajaxResult = new AjaxResult<>();
        ajaxResult.setCode(ExceptionEnum.SUCCESS.getCode());
        ajaxResult.setMsg(ExceptionEnum.SUCCESS.getMsg());
        return ajaxResult;
    }

    public static <T> AjaxResult<T> success(T data) {
        AjaxResult<T> ajaxResult = new AjaxResult<>();
        ajaxResult.setCode(ExceptionEnum.SUCCESS.getCode());
        ajaxResult.setMsg(ExceptionEnum.SUCCESS.getMsg());
        ajaxResult.setData(data);
        return ajaxResult;
    }

    public static <T> AjaxResult<T> fail(String code, String msg) {
        AjaxResult<T> responseDTO = new AjaxResult<>();
        responseDTO.setCode(code);
        responseDTO.setMsg(msg);
        return responseDTO;
    }

    public static <T> AjaxResult<T> fail(ExceptionEnum respEnum) {
        AjaxResult<T> responseDTO = new AjaxResult<>();
        responseDTO.setCode(respEnum.getCode());
        responseDTO.setMsg(respEnum.getMsg());
        return responseDTO;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}