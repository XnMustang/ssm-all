import com.wangjun.dao.AppointmentDao;
import com.wangjun.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 测试AppointmentDao接口测试
 * @Author : 王俊
 * @date :  2020/10/29
 */
public class AppointmentDaoTest extends BaseTest{

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment(){
        long bookId = 1000;
        long studentId = 2;
        int i = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("预约图书记录更新条数：" + i);
    }

    @Test
    public void testQueryByKeyWithBook(){
        long bookId = 1000;
        long studentId = 2;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println("通过主键查询预约记录：" + appointment);
    }


}
