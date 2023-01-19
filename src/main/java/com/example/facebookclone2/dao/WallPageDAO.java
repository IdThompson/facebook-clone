package com.example.facebookclone2.dao;




import com.example.facebookclone2.models.Posts;
import com.example.facebookclone2.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WallPageDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/facebook";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";


    private static final String SELECT_ALL_USER_POST = "select * from Posts where userId=?";
    private static final String DELETE_POST_SQL = "delete from Posts where postId= ?";
    private static final String UPDATE_USER_POST = "update Posts set content=? where postId=?";
    //    private static  final  String FETCH_ALL_POSTS_USER__NAMES= "select Posts.*,user.userName from Posts inner join user on Posts.userid=user.userId";
    private static final  String SELECT_POST_OWNER= "select * from user where userId=?";

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
    }


    public List<Posts> viewAllUsersPost(User user){
        List<Posts>listOfUsersPosts= new ArrayList<>();
        try (Connection connection= getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_USER_POST)){
            preparedStatement.setInt(1,user.getUserId());
            ResultSet result= preparedStatement.executeQuery();
            while(result.next()){
                String content= result.getString("content");
                int userId= result.getInt("userId");
                int postId= result.getInt("postId");
                Posts post = new Posts();
                post.setPostId(postId);
                post.setUserId(userId);
                post.setContent(content);
                listOfUsersPosts.add(post);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listOfUsersPosts;
    }

    public boolean deletePost(int postId) throws SQLException{

        boolean rowDeleted;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_POST_SQL)) {
            preparedStatement.setInt(1,postId);
            rowDeleted=preparedStatement.executeUpdate()>0;
        }
        return rowDeleted;

    }

    public boolean updateUserPost(Posts post) throws SQLException{
        boolean status;
        try(Connection connection= getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_USER_POST )) {
            preparedStatement.setInt(2,post.getPostId());
            preparedStatement.setString(1, post.getContent());
            status=preparedStatement.executeUpdate()>0;
        }
        return status;
    }
}



