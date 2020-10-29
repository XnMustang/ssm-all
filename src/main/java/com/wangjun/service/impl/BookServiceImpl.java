package com.wangjun.service.impl;

import com.wangjun.dao.AppointmentDao;
import com.wangjun.dao.BookDao;
import com.wangjun.entity.Appointment;
import com.wangjun.entity.Book;
import com.wangjun.enums.AppointStateEnum;
import com.wangjun.exception.AppointException;
import com.wangjun.exception.NoNumberException;
import com.wangjun.exception.RepeatAppointException;
import com.wangjun.service.BookService;
import com.wangjun.vo.AppointExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/10/29
 */
@Service
public class BookServiceImpl implements BookService {

    //引入slf4j的日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    /**
     * 查询单本图书
     * @param bookId 图书id
     * @return
     */
    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    /**
     * 查询所有图书
     * @return
     */
    @Override
    public List<Book> getAllBook() {
        return bookDao.queryAllBook(0,100);
    }

    @Override
    @Transactional  //不涉及RPC/HTTP可以使用此事务，微服务架构需要使用分布式事务；不是所有的方法都需要事务，如只有一条修改，只读操作等
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            //减库存
            int reduceNumber = bookDao.reduceNumber(bookId);
            //库存不足
            if(reduceNumber <= 0){
                throw new NoNumberException("库存不足，减库存失败！");
            }else {
                //库存足够 执行预约操作
                int insertAppointment = appointmentDao.insertAppointment(bookId, studentId);
                if(insertAppointment <= 0){
                    //重复预约
                    throw new RepeatAppointException("预约失败,重复预约！");
                }else {
                    //预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("内部错误！" + e.getMessage());
        }
    }
}
