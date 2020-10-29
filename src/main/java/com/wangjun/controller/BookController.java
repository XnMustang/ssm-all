package com.wangjun.controller;

import com.wangjun.entity.Book;
import com.wangjun.enums.AppointStateEnum;
import com.wangjun.exception.NoNumberException;
import com.wangjun.exception.RepeatAppointException;
import com.wangjun.service.BookService;
import com.wangjun.vo.AppointExecution;
import com.wangjun.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/10/29
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    //查看图书
    @RequestMapping(value = "/allBook",method = RequestMethod.GET)
    @ResponseBody
    public List<Book> allBook(){
        List<Book> allBook = bookService.getAllBook();
        return allBook;
    }

    @RequestMapping("/bookList")
    public String bookList(){
        return "allBook";
    }

    //预约图书
    @RequestMapping("/{bookId}/appoint")
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId,@RequestParam("studentId") Long studentId){
        if(studentId == null || studentId.equals("")){
            return new Result<>(false,"学号不允许为空");
        }
        //分情况处理异常
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        }catch (NoNumberException e1){
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        }catch (RepeatAppointException e2){
            execution = new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
        }catch (Exception e3){
            execution = new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
        };
        return new Result<AppointExecution>(true,execution);
    }

}
