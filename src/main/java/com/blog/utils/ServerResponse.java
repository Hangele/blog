package com.blog.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Hangele on 2018/10/17
 */
//Json序列化时过滤为null的字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable{

    private String status;
    private String msg;
    private T data;

    private ServerResponse(String status){
        this.status = status;
    }
    private ServerResponse(String status ,String msg,T data){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    private ServerResponse(String status ,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(String status ,String msg){
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status.equals(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    public  static <T> ServerResponse<T> createByErrorCodeMessage(String errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
    public static <T> ServerResponse<T> createByError(T data){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),data);
    }

}
