package com.ptteng;//文件名

import java.util.List;

public interface JdbcDAO {
        //创建DAO接口
        List<Jdbc1> findA11();

        int insert(Jdbc1  jdbc1);
        Jdbc1 findaByID(int id);
        boolean update(Jdbc1 Jdbc1);
        boolean delete(int id);


}


