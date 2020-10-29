package com.wangjun.enums;

import com.wangjun.entity.Appointment;

/**
 * @Description:  定义预约图书业务数据字典
 * @Author : 王俊
 * @date :  2020/10/29
 */
public enum AppointStateEnum {

    SUCCESS(1, "预约成功"),
    NO_NUMBER(0, "库存不足"),
    REPEAT_APPOINT(-1, "重复预约"),
    INNER_ERROR(-2, "系统异常");

    //状态码
    private int state;
    //状态信息
    private String stateInfo;

    private AppointStateEnum(int state,String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AppointStateEnum stateOf(int index){
        for(AppointStateEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
