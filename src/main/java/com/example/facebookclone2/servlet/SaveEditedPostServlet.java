package com.example.facebookclone2.servlet;



import com.example.facebookclone2.dao.PostDAO;
import com.example.facebookclone2.dao.WallPageDAO;
import com.example.facebookclone2.models.Posts;
import com.example.facebookclone2.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/saveEdited")
public class SaveEditedPostServlet extends HttpServlet {
    WallPageDAO wallPageDAO= new WallPageDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String content= req.getParameter("edited-post");
            int postId= Integer.parseInt(req.getParameter("id"));
            HttpSession session = req.getSession();
            User user= (User) session.getAttribute("user");
            Posts post = new Posts();
            post.setPostId(postId);
            post.setContent(content);
            post.setUserId(user.getUserId());
            Boolean status= wallPageDAO.updateUserPost(post);
            System.out.println(status);
            if(status){
                RequestDispatcher dispatcher= req.getRequestDispatcher("wall");
                dispatcher.forward(req,resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
