package com.example.facebookclone2.servlet;



import com.example.facebookclone2.dao.DashboardDAO;
import com.example.facebookclone2.dao.UserDAO;
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

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    private UserDAO userDAO;
    private DashboardDAO dashboardDAO;

    public void init() {
        //message = "Hello World!";
        userDAO= new UserDAO();
        dashboardDAO=new DashboardDAO();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String name= request.getParameter("login_username");
        String password= request.getParameter("login_password");


        try {
            User user1= userDAO.getUser(name,password);
            if(user1!=null){
                HttpSession session= request.getSession();
                List<Posts>posts=dashboardDAO.displayAllOtherUsersPosts(user1);
                session.setAttribute("user",user1);
                session.setAttribute("posts",posts);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                dispatcher.forward(request, response);
            }else{
                String message= "Invalid username or password";
                request.setAttribute("message",message);
            }


//
//            RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
//            dispatcher.forward(request, response);
        }catch(ServletException ex){
            ex.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void destroy() {
    }
}
