package com.it;





import com.sun.deploy.model.Resource;
import dao.IUserDao;


import dumain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    //单个查询
   /* @Test
    public void findUserByIdTset() throws IOException {
        //Mybatis配置文件
        String resource = "config.xml";
        //得到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //通过SqlSession操作数据库
        //第一个数据是namespace+statmend 的id
        //第二个参数：指定映射文件中所匹配的parameType类型的值

        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }


    //根据用户名模糊查询
    @Test
    public void findUserByNameTset() throws IOException {
        //Mybatis配置文件
        String resource = "config.xml";
        //得到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List中的user和映射文件中的resultType所指定的类型一致
    List<User>list = sqlSession.selectList("test.findUserByName","你");
    System.out.println(list);
    sqlSession.close();
    }


    //插入
    @Test
    public void insertUserTest() throws IOException {
        //Mybatis配置文件
        String resource = "config.xml";
        //得到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //插入用户对象
        User user = new User();
        user.setName("1267567");

        sqlSession.insert("test.insertUser", user);

        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();


    }*/


    //删除
    /*@Test
   public void deleteUserTest() throws IOException {
        //Mybatis配置文件
        String resource = "config.xml";
        //得到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //传入id删除用户
        sqlSession.delete("test.deleteUser", 4);

        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();


    }*/

    //更新
    @Test
    public void updateUserTest() throws IOException {
        //Mybatis配置文件
        String resource = "config.xml";
        //得到配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //更新用户信息
        User user = new User();
        //必须设置ID
        user.setId(2);
        user.setName("孙悟空");

        sqlSession.update("test.updateUser", user);

        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }
}
