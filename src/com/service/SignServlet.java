package com.service;

import com.Dao.UserDao;
import com.com.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignServlet",urlPatterns = "/SignServlet")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String signType = request.getParameter("sign");
        UserDao userDao = new UserDao();

        if("登录".equals(signType)){

            String uName = request.getParameter("username");
            String uPassword = request.getParameter("password");
            User user = userDao.getUser(uName,uPassword);

            if (user == null){
                httpSession.setAttribute("LoginError","用户名或密码错误");
               response.sendRedirect(request.getContextPath()+"/page/Login.jsp");
            }else{
                httpSession.setAttribute("userName",user.getuName());
                httpSession.setAttribute("password",user.getuPassword());

                if (new UserDao().checkMaster(user.getuName())){
                    response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=0");
                }else{
                    response.sendRedirect(request.getContextPath()+"/page/Home.jsp");
                }
            }

        }else if ("注册".equals(signType)){
            response.sendRedirect("/page/SignUP.jsp");
        }

    }

}
