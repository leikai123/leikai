package dao;

import dumain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

    void saveUser(User user);

    User selectUser(Integer id);

    void updateUser(User user);

    void DeleteUser(Integer id);

    List<User> findUserByName();

}
