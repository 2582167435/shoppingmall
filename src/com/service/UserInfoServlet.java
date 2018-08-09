package com.service;

import com.Dao.UserDao;
import com.Dao.UserInfoDao;
import com.com.bean.User;
import com.com.bean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserInfoServlet",urlPatterns = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String userName = (String) httpSession.getAttribute("userName");
        String password = (String) httpSession.getAttribute("password");
        User user = new UserDao().getUser(userName,password);
        UserInfo userInfo = new UserInfoDao().getUserInfo(userName);

        System.out.println(userInfo.getUiName());
        request.setAttribute("user",user);
        request.setAttribute("userInfo",userInfo);

        httpSession.setAttribute("user",user);
        httpSession.setAttribute("userInfo",userInfo);

        request.getRequestDispatcher("/page/UserInfo.jsp").forward(request,response);
    }
}
