import com.wangjun.exception.AppointException;
import com.wangjun.service.BookService;
import com.wangjun.vo.AppointExecution;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint(){
        long bookId = 1001;
        long studentId = 12345678910L;
        AppointExecution appoint = bookService.appoint(bookId, studentId);
        System.out.println(appoint);
    }

}
