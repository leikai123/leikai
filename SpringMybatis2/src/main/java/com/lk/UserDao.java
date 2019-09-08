package com.lk;

import java.util.List;

public interface UserDao {
    int add (User user);
    boolean delete (int id);
    boolean update (User user);
    List<User> findAll();
    User findById(int id);

}
