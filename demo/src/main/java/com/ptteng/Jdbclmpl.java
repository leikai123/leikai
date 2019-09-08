

package com.ptteng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//实现

public class Jdbclmpl implements JdbcDAO {

    // 删除
    public boolean delete(int id) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql = "delete from baoming where id=?";
        int pp = jdbcTemplate.update(sql, id);
        System.out.println("success");
        if (pp > 0) {
            return true;
        }
        return false;
    }


//查找全部


    public List<Jdbc1> findA11() {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        String sql = "select * from baoming";
        final List<Jdbc1> listAllJdbc1 = new ArrayList<Jdbc1>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {


                    public void processRow(ResultSet resultSet) throws SQLException {
                        Jdbc1 s = new Jdbc1();
                        s.setId(resultSet.getInt("id"));
                        s.setName(resultSet.getString("name"));
                        listAllJdbc1.add(s);
                    }

                }

        );

        return listAllJdbc1;
    }


    //增加
    public int insert(final Jdbc1 jdbc1) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

        final String sql = "insert into baoming(id,name )values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, jdbc1.getId());
                ps.setString(2, jdbc1.getName());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().byteValue();
    }


    //改


    public boolean update(Jdbc1 Jdbc1) {


        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

        String sql = "update baoming set name = ? where id = ?";
        int pp = jdbcTemplate.update(sql, Jdbc1.getName(), Jdbc1.getId());
        if (pp > 0) {
            return true;
        }
        return false;
    }


//查找其中一个



    public Jdbc1 findaByID(int id) {     //定义一个方法，返回值是JDBC1，方法名为findByID 形参为int id
        //启动IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中JDBCTemplate实例
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        //查询方法
        String sql = "select * from Jdbc1 where id=?";
        //实例化JDBC1， 返回值为JDBC1
        final Jdbc1 jdbc1 = new Jdbc1();
        jdbcTemplate.query(sql, new RowMapper<Object>() {
                    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                        jdbc1.setId(resultSet.getInt("id"));
                        jdbc1.setName(resultSet.getString("name"));//读取单个对象
                        return jdbc1;
                    }
                }, id
        );
        return jdbc1;
    }
}

























































