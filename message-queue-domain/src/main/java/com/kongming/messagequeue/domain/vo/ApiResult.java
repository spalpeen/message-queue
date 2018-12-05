package com.kongming.messagequeue.domain.vo;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class ApiResult<T> extends ResultSupport{

    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 接口调用失败,有错误字符串码和描述,有返回对象
     * @param code
     * @param message
     * @param data
     * @param <U>
     * @return
     */
    public static <U> ApiResult<U> failResult(int code, String message, U data) {
        ApiResult<U> apiResult = new ApiResult<U>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }

    /**
     * 接口调用失败,有错误字符串码和描述,没有返回对象
     * @param code
     * @param message
     * @param <U>
     * @return
     */
    public static <U> ApiResult<U> failResult(int code, String message) {
        ApiResult<U> apiResult = new ApiResult<U>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }


    public static <U> ApiResult<U> successResult(U data){
        ApiResult<U> apiResult = new ApiResult<U>();
        apiResult.setData(data);
        return apiResult;
    }

    public static <U> ApiResult<U> successResult(int code)
    {
        ApiResult<U> apiResult = new ApiResult<U>();
        apiResult.setLogId(String.valueOf(UUID.randomUUID()));
        apiResult.setCode(code);
        apiResult.setMessage("success");
        return apiResult;
    }
}

