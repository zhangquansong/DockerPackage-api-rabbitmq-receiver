package com.clt.api.utils;

import java.io.Serializable;

/**
 * @ClassName : RestResult
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:17
 * @Description :接口返回包装类
 **/
public class RestResult<T> implements Serializable {

    private Integer code;//状态码
    private String message;//返回信息
    private T data;//返回数据

    public RestResult() {
    }

    public RestResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RestResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> RestResult<T> response(Integer code, T data) {
        return new RestResult(code, RestConstants.getMessageByCode(code).getMessage(), data);
    }

    public static <T> RestResult<T> successResponse() {
        return new RestResult(RestConstants.SUCCESS.getCode(),
                RestConstants.getMessageByCode(RestConstants.SUCCESS.getCode()).getMessage());
    }

    public static <T> RestResult<T> successResponse(T data) {
        return new RestResult(RestConstants.SUCCESS.getCode(),
                RestConstants.getMessageByCode(RestConstants.SUCCESS.getCode()).getMessage(), data);
    }

    public static <T> RestResult<T> errorResponse() {
        return new RestResult(RestConstants.ERROR.getCode(),
                RestConstants.getMessageByCode(RestConstants.ERROR.getCode()).getMessage());
    }

    public static <T> RestResult<T> errorResponse(Integer code, String message) {
        return new RestResult(code, message);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
