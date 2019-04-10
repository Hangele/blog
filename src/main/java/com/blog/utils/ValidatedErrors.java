package com.blog.utils;

import org.springframework.validation.BindingResult;

import java.util.Map;

/**
 * @package: com.supplychain.common.utils
 * @Date: 2018/7/26 10:41
 * @Author: Hangele
 * @Description: 遍历参数校验返回的错误信息
 */
public class ValidatedErrors {


    public static ServerResponse<Map> getErrors(BindingResult result){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<result.getAllErrors().size();i++){
            String error = result.getAllErrors().get(i).getDefaultMessage();
            sb.append(error);
            if(i < result.getAllErrors().size()-1){
                sb.append(",");
            }
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.DataIsEmpty.getCode(),sb.toString());
    }

}
