package com.service;

import com.Dao.GoodsDao;
import com.com.bean.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsServlet",urlPatterns = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("find");
        List<Goods> list =  new GoodsDao().getGoodList(str);
        request.getSession().setAttribute("Goods",list);
        response.sendRedirect("/page/Goods.jsp");
    }


}
