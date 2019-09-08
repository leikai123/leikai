import com.lk.User;
import com.lk.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    //1.根据xml配置文件（全局配置文件）创建一个sqlSession对象
   /* @Test
    public void MybatisTest() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession实例，能直接执行已经映射的sqly语句

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //第一个参数传sql的唯一标识（namespa+id就完整了）告诉mybatis要执行哪个sql
            //第二个执行sql要用的参数
            User user = openSession.selectOne("test.selectUser", 3);
            System.out.println("user"+user);
        }finally {
            openSession.close();
        }


    }*/
    @Test

    public void test01() throws IOException {
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象,用来调用接口的方法
            //会为接口自动创建一个代理对象，由代理对象执行增删改查方法。
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(3);

            System.out.println(user);
        } finally {
            openSession.close();

        }


    }



}




