package com.service;

import com.Dao.EntryDao;
import com.com.bean.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateEntryServlet",urlPatterns ="/UpdateEntryServlet")
public class UpdateEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entry entry = (Entry)request.getSession().getAttribute("updateentry");
        new EntryDao().updateStatusEntry(entry.geteID());
        response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=5&flag=1");

    }
}
