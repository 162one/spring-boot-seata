package com.seata.exception;

public interface BaseErrorInfoInterface {
    /**
     * 错误码
     */
    String getCode();

    /**
     * 错误描述
     */
    String getMsg();
}