package com.wangjun.exception;

import com.wangjun.entity.Appointment;
import com.wangjun.enums.AppointStateEnum;

/**
 * @Description: 预约业务异常
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class AppointException extends RuntimeException{

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
