package Service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

    void insertUser(User user) throws SQLException;

    User selectUser(int id);

     List<User> selectAllUsers();

    void deleteUser(int id) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<User> findUserByCountry(String country);
}
