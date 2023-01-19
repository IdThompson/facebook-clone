package com.example.facebookclone2.dao;



import com.example.facebookclone2.models.Likes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikesDAO  {
    private String jdbcURL = "jdbc:mysql://localhost:3306/facebook";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";


    private static final String SELECT_ALL_LIKES_IN_A_POST= "select * from likes where postId=?";
    private static final String CREATE_NEW_LIKE= "insert into likes " + " (postId,userID) VALUES"+"(?,?)";
    private static final String DELETE_LIKE="delete from likes where likes_Id=?";
    private static final String CHECK_LIKE= "select * from likes where postId=? and userID=?";

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


    public void  LikeAPost(int userId,int postId){
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(CREATE_NEW_LIKE)){
            preparedStatement.setInt(1,postId);
            preparedStatement.setInt(2,userId);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public  Boolean unlikeAPost(int like_id){
        Boolean status= false;
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(DELETE_LIKE)){
            preparedStatement.setInt(1,like_id);
            System.out.println(preparedStatement);
            status=preparedStatement.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Likes> displayAllLikesCount(int postId){
        List<Likes> allLikes= new ArrayList<>();
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_LIKES_IN_A_POST)){
            preparedStatement.setInt(1,postId);
            ResultSet result= preparedStatement.executeQuery();
            while (result.next()){
                int userId= result.getInt("userID");
                int likesId= result.getInt("likes_id");
                Likes like = new Likes();
                like.setLikesId(likesId);
                like.setPostId(postId);
                like.setUserId(userId);
                allLikes.add(like);
            }

//            System.out.println(preparedStatement);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return allLikes;
    }


    public Likes checkLike(int postId,int userId){
        Likes like = new Likes();
        try (  Connection connection= getConnection();
               PreparedStatement preparedStatement= connection.prepareStatement(CHECK_LIKE)){
            preparedStatement.setInt(1,postId);
            preparedStatement.setInt(2,userId);
            ResultSet result= preparedStatement.executeQuery();
            while (result.next()){
                int likesId= result.getInt("likes_id");
                like.setLikesId(likesId);
                like.setPostId(postId);
                like.setUserId(userId);
            }

            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return like;
    }

}
