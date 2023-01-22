package com.example.facebookclone2.servlet;



import com.example.facebookclone2.dao.UserDAO;
import com.example.facebookclone2.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
    private UserDAO userDAO;

    public  void init(){
        userDAO= new UserDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String userName= request.getParameter("userName");
        String password= request.getParameter("password");
        String firstName= request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
        String country= request.getParameter("country");
        String email= request.getParameter("email");

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassWord(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setCountry(country);

        try {

            userDAO.createUser(newUser);
            RequestDispatcher dispatcher= request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
