package com.wangjun.exception;

/**
 * @Description: 库存不足异常
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message,cause);
    }

}
