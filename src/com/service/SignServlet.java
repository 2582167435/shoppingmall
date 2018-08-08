package com.service;

import com.Dao.UserDao;
import com.com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignServlet",urlPatterns = "/SignServlet")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String signType = request.getParameter("sign");
        UserDao userDao = new UserDao();

        if("登陆".equals(signType)){

            String uName = request.getParameter("username");
            String uPassword = request.getParameter("password");
            User user = userDao.getUser(uName,uPassword);

            if (user == null){
               request.getSession().setAttribute("LoginError","用户名或密码错误");
               response.sendRedirect(request.getContextPath()+"/page/Login.jsp");
            }else{
                request.getSession().setAttribute("username",user.getuName());
                request.getSession().setAttribute("password",user.getuPassword());

                response.sendRedirect(request.getContextPath()+"/page/Home.jsp");
            }

        }else if ("注册".equals(signType)){
            response.sendRedirect("/page/SignUP.jsp");
        }

    }

}
