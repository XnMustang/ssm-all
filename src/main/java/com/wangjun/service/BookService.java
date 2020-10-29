package com.wangjun.service;

import com.wangjun.entity.Book;
import com.wangjun.vo.AppointExecution;

import java.util.List;

/**
 * @Description: Book业务接口
 * @Author : 王俊
 * @date :  2020/10/29
 */
public interface BookService {

    /**
     * 通过ID查找图书信息
     * @param bookId 图书id
     * @return 图书信息
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     * @return 图书列表
     */
    List<Book> getAllBook();

    /**
     * 预约图书
     * @param bookId 图书id
     * @param studentId 学生id
     * @return 返回预约信息
     */
    AppointExecution appoint(long bookId, long studentId);

}
