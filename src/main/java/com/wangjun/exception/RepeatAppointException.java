package com.wangjun.exception;

/**
 * @Description: 重复预约异常
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class RepeatAppointException extends RuntimeException{

    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }

}
