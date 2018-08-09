package com.service;

import com.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignUPServlet",urlPatterns = "/SignUPServlet")
public class SignUPServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        UserDao user = new UserDao();
        boolean flag = user.Insert(name,password,telephone,address,email);
        if (flag){
            httpSession.setAttribute("userName",request.getParameter("username"));
            httpSession.setAttribute("password",request.getParameter("password"));
            response.sendRedirect(request.getContextPath()+"/page/Home.jsp");
        }else {
            request.getSession().setAttribute("registerError","注册失败");
            response.sendRedirect(request.getContextPath()+"/page/SignUP.jsp");
        }

    }

}
