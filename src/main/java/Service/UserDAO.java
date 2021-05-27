package Service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDao {
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id =?";
    private static final String INSERT_USER_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
        " (?, ?, ?);";
    private static final String UPDATE_USER_SQL = "UPDATE user SET name=?, email=?, country=? WHERE id=?";
    private static final String DELETE_USER_SQL = "DELETE FROM user where id=?";
    private static final String SELECT_USER_BY_COUNTRY = "SELECT * FROM user WHERE country like ?";
    private Connection getConnect(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo",
                    "root",
                    "quangha97"
            );
//            System.out.println("Thannh cong");
        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("That bai");
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public List<User> findUserByCountry(String country) {
        String search = "%" + country + "%";
        Connection connection = getConnect();
        //day này
        List <User> listUerByCountry = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            statement.setString(1,search);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                listUerByCountry.add(new User(id, name, email, country1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUerByCountry;
    }

    @Override
    public void insertUser(User user){
        Connection c = getConnect();
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_USER_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
                statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = getConnect();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idresult = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(idresult,name,email,country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        Connection c = getConnect();;
        PreparedStatement statement;
        List<User> users = new ArrayList<>();
        try {
            statement = c.prepareStatement("SELECT * FROM user ORDER BY name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = getConnect();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    @Override
    public void updateUser(User user){
        Connection connection = getConnect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_USER_SQL);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getCountry());
            statement.setInt(4,user.getId());
            statement.executeUpdate();
            System.out.println("update thanh cong");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
