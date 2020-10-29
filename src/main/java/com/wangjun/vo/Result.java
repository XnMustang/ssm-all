package com.wangjun.vo;

/**
 * @Description: 封装json返回结果
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class Result<T> {

    private boolean success;    //是否成功
    private T data;     //成功时返回的数据
    private String errorInfo;   //错误信息

    public Result(){}

    //成功的构造器
    public Result(boolean success,T data){
        this.success = success;
        this.data = data;
    }
    //错误的构造器
    public Result(boolean success,String errorInfo){
        this.success = success;
        this.errorInfo = errorInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
