package com.wangjun.dao;

import com.wangjun.entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 预约图书接口
 * @Author : 王俊
 * @date :  2020/10/29
 */
public interface AppointmentDao {

    /**
     * 插入预约图书记录
     * @param bookId    图书id
     * @param studentId 学生id
     * @return 插入行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
