package com.service;

import com.Dao.EntryDao;
import com.com.bean.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("index").equals("0")){
            List<Entry> list = new EntryDao().getEntrys(request.getParameter("find"));
            request.getSession().setAttribute("selectentry",list);
            response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=0");
        }
    }

}
