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
import java.util.List;

@WebServlet("/edit")
public class EditPostServlet extends HttpServlet {
    @Override
    public void init(){
        WallPageDAO wallPageDAO= new WallPageDAO();
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WallPageDAO wallPageDAO= new WallPageDAO();
        PostDAO postDAO= new PostDAO();
        resp.setContentType("text/html");
        HttpSession session= req.getSession();
        List<Posts> postsList= (List<Posts>) session.getAttribute("usersPost");
//            String content= req.getParameter("value");
        int postId=  Integer.valueOf(req.getParameter("id"));
//        User user=(User) session.getAttribute("user");
//        int userId= user.getUserId();
        Posts post=postDAO.getPost(postId);
        System.out.println(post);
        req.setAttribute("updatePost",post);
        RequestDispatcher dispatcher= req.getRequestDispatcher("editedPosts.jsp");
        dispatcher.forward(req,resp);


    }
}
