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

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        User user = (User) httpSession.getAttribute("user");
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");

        user.setuPassword(request.getParameter("password"));
        userInfo.setUiTelephone(request.getParameter("telephone"));
        userInfo.setUiAddress(request.getParameter("address"));
        userInfo.setUiEmail(request.getParameter("email"));

        String uName = (String)httpSession.getAttribute("userName");

        boolean success = new UserDao().updateUser(user,uName) && new UserInfoDao().updateUserInfo(userInfo,uName);
        if (success){
            httpSession.setAttribute("password",request.getParameter("password"));
            response.sendRedirect(request.getContextPath()+"/page/Home.jsp");
        }else {
            request.getSession().setAttribute("UpdateError","修改失败");
            response.sendRedirect(request.getContextPath()+"/UserInfoServlet");
        }
    }
}
