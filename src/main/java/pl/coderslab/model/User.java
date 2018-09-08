package pl.coderslab.model;

//import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User() {
        this.id = 0;
        this.username = null;
        this.email = null;
        this.password = null;
    }

    public User(String userName, String email, String password) {
        this.username = userName;
        this.email = email;
        this.setPassword(password);
    }

    public User(int id, String userName, String email, String password) {
        this.id = id;
        this.username = userName;
        this.email = email;
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void update(int id, String userName, String email, String password) {

    }

    public void delete(Connection conn, int id) {
        String sql = "DELETE ";
    }

    static public User[] loadAll(Connection conn) throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User loadUser = new User();
            loadUser.id = resultSet.getInt("id");
            loadUser.username = resultSet.getString("username");
            loadUser.email = resultSet.getString("email");
            loadUser.password = resultSet.getString("password");
            users.add(loadUser);
        }
        User[] uArray = new User[users.size()];
        uArray = users.toArray(uArray);
        return uArray;
    }

    static public User loadById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User loadUser = new User();
            loadUser.id = resultSet.getInt("id");
            loadUser.username = resultSet.getString("username");
            loadUser.email = resultSet.getString("email");
            loadUser.password = resultSet.getString("password");
            return loadUser;
        }
        return null;
    }

    public void saveToDB(Connection connection) throws SQLException {
        if (this.id == 0) {
            String sql = "INSERT INTO user(username, email, password, user_group_id) VALUES (?, ?, ?, 1)";
            String[] generatedColumns = {"ID"};
            PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.password);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
        }
    }
}
