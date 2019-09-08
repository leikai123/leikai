package com.ptteng;//文件名

import com.ptteng.Jdbc1;
import com.ptteng.JdbcDAO;
import com.ptteng.Jdbclmpl;

public class JdbcTest {
    static JdbcDAO JdbcDAO = new Jdbclmpl();

    public JdbcTest() {
    }

    public static void main(String[] args) {
        Jdbc1 s = new Jdbc1();
      // s.setName("wan");
       //s.setId(1);

       //System.out.println(JdbcDAO.update(s));
       // System.out.println(JdbcDAO.findaByID(3));
       System.out.println(JdbcDAO.findA11());
        System.out.println(JdbcDAO.delete(1));
        //System.out.println(JdbcDAO.insert(s));
    }
}
