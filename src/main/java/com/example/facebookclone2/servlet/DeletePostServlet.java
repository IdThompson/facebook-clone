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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleted")
public class DeletePostServlet extends HttpServlet {
    WallPageDAO wallPageDAO;
    public void init(){
        wallPageDAO= new WallPageDAO();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            response.setContentType("text/html");
            HttpSession session = request.getSession();
            int postId = Integer.valueOf(request.getParameter("id"));
            System.out.println(postId);
//           User user= (User) session.getAttribute("user");
            boolean status = wallPageDAO.deletePost(postId);
//           List<Posts> postsList = wallPageDAO.viewAllUsersPost(user);
            System.out.println(status);
            if (status) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/wall");
                dispatcher.forward(request, response);
//                response.sendRedirect("userWall.jsp");
            }

        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }


}
