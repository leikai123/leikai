package com.lk;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaolmpl extends SqlSessionDaoSupport {
    public User findById(int id) {
        //继承SqlSessionDaoSupport，通过this.getSqlSession();得到SqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("findById", id);
        return user;
    }
}
