package com.service;

import com.Dao.EntryDao;
import com.com.bean.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AlterEntryServlet",urlPatterns = "/AlterEntryServlet")
public class AlterEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entry entry = (Entry)request.getSession().getAttribute("alterentry");
        entry.setgID(Integer.valueOf(request.getParameter("gid")));
        entry.setsID(Integer.valueOf(request.getParameter("sid")));
        entry.setEntryManager(request.getParameter("entrymanager"));
        entry.seteCount(Integer.valueOf(request.getParameter("count")));
        entry.seteWay(request.getParameter("way"));
        new EntryDao().alterEntry(entry);
        response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=3&flag=1");
    }

}
