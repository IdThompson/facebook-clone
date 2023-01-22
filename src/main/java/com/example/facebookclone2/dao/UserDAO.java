package com.example.facebookclone2.dao;



import com.example.facebookclone2.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/facebook";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String CREATE_NEW_USER= "INSERT INTO user (username, email, firstname, lastname, country, password) VALUES ( ?,?,?,?,?,?)";
    private static final String SELECT_ALL_USERS= "select * from user";
    private static final String SELECT_USER_BY_ID= "select * from user where username =? and password=?";
    private static final String DELETE_USER_SQL = "delete from user where username= ?";
    private static final String  SELECT_POST_OWNER= "select from user where id=?";


    private Connection getConnection(){
        Connection connection= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;

    };


    public void createUser(User user) throws SQLException{
//        int status=0;
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(CREATE_NEW_USER)){
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getFirstName());
            preparedStatement.setString(4,user.getLastName());
            preparedStatement.setString(5,user.getCountry());
            preparedStatement.setString(6,user.getPassWord());
            System.out.println(preparedStatement);
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        User user = new User("Olu", "olu@gmail", "Olu", "Olu", "Nigeria", "pass");
        userDAO.createUser(user);
    }


    public List<User> selectAllUsers() throws SQLException{
        List<User>users = new ArrayList<>();
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_USERS)) {

            ResultSet result= preparedStatement.executeQuery();

            while(result.next()){
                int id= result.getInt("id");
                String name= result.getString("username");
                String email= result.getString("email");
                String firstName= result.getString("firstname");
                String lastName= result.getString("lastname");
                String country = result.getString("country");
                String passWord= result.getString("password");
                User user= new User();
                user.setUserId(id);
                user.setUserName(name);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setCountry(country);
                user.setPassWord(passWord);
                users.add(user);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public User getUser(String userName, String passWord) throws SQLException{
        User user = null;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,passWord);
            ResultSet result= preparedStatement.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String email= result.getString("email");
                String firstName= result.getString("firstname");
                String lastName= result.getString("lastname");
                String country = result.getString("country");
                user = new User();
                user.setUserName(userName);
                user.setPassWord(passWord);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setCountry(country);
                user.setEmail(email);
                user.setUserId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean deleteUser(String userName) throws SQLException{
        boolean rowDeleted;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setString(1,userName);
            rowDeleted=preparedStatement.executeUpdate()>0;
        }
        return rowDeleted;
    }

    public User getPostOwner(int userId) throws SQLException {
        User user = null;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_POST_OWNER)) {

            ResultSet result= preparedStatement.executeQuery();

            while(result.next()){
                int id = result.getInt("userId");
                String email= result.getString("email");
                String firstName= result.getString("firstName");
                String lastName= result.getString("lastName");
                String country = result.getString("country");
                String userName = result.getString("userName");
                user = new User();
                user.setUserName(userName);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setCountry(country);
                user.setEmail(email);
                user.setUserId(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }


}
