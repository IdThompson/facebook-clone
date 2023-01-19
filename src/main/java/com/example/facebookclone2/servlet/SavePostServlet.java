package com.example.facebookclone2.servlet;


import com.example.facebookclone2.dao.PostDAO;
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
import java.util.List;

@WebServlet("/savePost")
public class SavePostServlet extends HttpServlet {
    private PostDAO postDAO;

    public void init(){
        postDAO=new PostDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/wall");
        try {
            response.setContentType("text/html");
            String newContent= request.getParameter("user-new-post");
            HttpSession session= request.getSession();
            User user= (User)session.getAttribute("user");
            postDAO.createNewPost(newContent,user.getUserId());

            dispatcher.forward(request,response);
        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }
}

