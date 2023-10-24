package com.seata.exception;

public enum ExceptionEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    SUCCESS("200", "操作成功!"),

    BODY_NOT_MATCH("400", "请求的数据格式不符!"),

    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),

    REJECT_REQUEST("403", "服务器拒绝请求!"),

    NOT_FOUND("404", "未找到该资源!"),

    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),

    SERVER_BUSY("503", "服务器正忙，请稍后再试!");

    /**
     * 状态码
     */
    private String code;

    /**
     * 描述
     */
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}