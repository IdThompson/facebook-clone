package com.example.facebookclone2.dao;


import com.example.facebookclone2.models.Posts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/facebook";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String CREATE_NEW_POST= "INSERT INTO Posts" + "(content,userId)VALUES" +"(?,?)";
    private static final String SELECT_ALL_POST= "select * from Posts";
    private static final String SELECT_SPECIFIC_POST= "select * from Posts where postId=?";


    private Connection getConnection(){
        Connection dataConnection= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return dataConnection;
    };

    public void createNewPost(String post, int userId) throws SQLException{
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(CREATE_NEW_POST)){
            preparedStatement.setString(1, post);
            preparedStatement.setInt(2,userId);
            //preparedStatement.setDate(2, Date.valueOf(post.getDateCreated().toLocalDate()));
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Posts> viewAllPosts() throws SQLException{
        List<Posts>posts = new ArrayList<>();
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_POST)) {

            ResultSet result= preparedStatement.executeQuery();

            while(result.next()){
                int id= result.getInt("postId");
                String content= result.getString("content");
//                Date dateCreated= result.getDate("dateCreated");
                Posts post = new Posts();
                post.setPostId(id);
                post.setContent(content);
                posts.add(post);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return posts;
    }

    public Posts getPost(int postId){
        Posts post = new Posts();
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_SPECIFIC_POST)){
            preparedStatement.setInt(Integer.parseInt("1"),postId);
            ResultSet result= preparedStatement.executeQuery();
            while(result.next()){
                int userId= result.getInt("userId");
                String content= result.getString("content");
                post.setContent(content);
                post.setPostId(postId);
                post.setUserId(userId);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
    }


}



