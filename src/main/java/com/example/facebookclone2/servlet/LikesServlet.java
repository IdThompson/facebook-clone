package com.example.facebookclone2.servlet;


import com.example.facebookclone2.dao.LikesDAO;
import com.example.facebookclone2.models.Likes;
import com.example.facebookclone2.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/likes")
public class LikesServlet extends HttpServlet {
    LikesDAO likesDAO= new LikesDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            int postId= Integer.parseInt(req.getParameter("id"));
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            Likes like= likesDAO.checkLike(postId,user.getUserId());
            if(like.getLikesId()<1){
                likesDAO.LikeAPost(user.getUserId(),postId);
                List<Likes> likesList= likesDAO.displayAllLikesCount(postId);
                req.setAttribute("likes",likesList);
                RequestDispatcher dispatcher= req.getRequestDispatcher("/userWall.jsp");
                dispatcher.forward(req,resp);
            }
            else {
                likesDAO.unlikeAPost(like.getLikesId());
                List<Likes> likesList= likesDAO.displayAllLikesCount(postId);
                req.setAttribute("likes",likesList);
                RequestDispatcher dispatcher= req.getRequestDispatcher("/userWall.jsp");
                dispatcher.forward(req,resp);
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
