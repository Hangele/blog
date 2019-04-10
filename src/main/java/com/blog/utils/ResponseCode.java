package com.blog.utils;

/**
 * Created by Hangele on 2018/10/17
 */
public enum ResponseCode {

    SUCCESS("0000","SUCCESS"),
    ERROR("0001","异常"),
    DataNotExit("0002","数据不存在"),
    DataIsEmpty("0003","参数为空"),
    OperationFail("0004","操作失败，请重试");

    private final String code;
    private final String desc;

    ResponseCode(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
