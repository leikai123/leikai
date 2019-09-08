import com.lk.User;
import com.lk.UserDaolmpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    private static Logger logger = Logger.getLogger(UserTest.class);
    @Test
    public void findUserById(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserDaolmpl userDaoImpl =(UserDaolmpl) applicationContext.getBean("UserDao");
        User user =userDaoImpl.findById(4);
        System.out.println(user);
    }

}
