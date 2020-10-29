import com.wangjun.dao.BookDao;
import com.wangjun.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 测试bookDao中接口是否正常
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class BookDaoTest extends BaseTest{

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() throws Exception {
        long bookId = 1001;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testReduceNumber(){
        long bookId = 1000;
        int i = bookDao.reduceNumber(bookId);
        System.out.println("执行结果：" + i);
    }

    @Test
    public void testQueryAllBook(){
        int offset = 0;
        int limit = 2;
        List<Book> books = bookDao.queryAllBook(offset, limit);
        for (Book book : books) {
            System.out.println("分页查询：" + book);
        }
    }

}
