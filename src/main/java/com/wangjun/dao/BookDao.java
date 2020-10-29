package com.wangjun.dao;

import com.wangjun.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 图书接口
 * @Author : 王俊
 * @date :  2020/10/29
 */
public interface BookDao {

    /**
     * 通过图书ID查询单本图书
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 减少馆藏数量
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);

    /**
     * 查询所有图书
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return
     */
    List<Book> queryAllBook(@Param("offset") int offset, @Param("limit") int limit);

}
