package com.example.facebookclone2.servlet;



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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/wall")
public class UserWallServlet extends HttpServlet {
    WallPageDAO wallPageDAO;

    public void init(){
        wallPageDAO= new WallPageDAO();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = req.getRequestDispatcher("userWall.jsp");
            HttpSession session= req.getSession();
            User user= (User)session.getAttribute("user");
            List <Posts>userPost=wallPageDAO.viewAllUsersPost(user);
            if(userPost.size()==0){
//               req.setAttribute("emptypost","No posts yet")
                resp.sendRedirect("emptyPost.jsp");
            }else{
                session.setAttribute("usersPosts",userPost);
                resp.setContentType("text/html");
                dispatcher.forward(req,resp);}
        }catch (IndexOutOfBoundsException e){

            e.printStackTrace();

            e.printStackTrace();
        }

    }
}
