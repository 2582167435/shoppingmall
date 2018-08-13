package com.service;

import com.Dao.EntryDao;
import com.com.bean.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EntryServlet",urlPatterns = "/EntryServlet")
public class EntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("entry")==null) {
            Entry entry = new Entry();
            Date date = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("ddHHmmss");
            SimpleDateFormat format2 = new SimpleDateFormat("yymmddHHmmss");
            entry.seteID(Integer.valueOf(format1.format(date)));
            entry.setgID(Integer.valueOf(request.getParameter("gid")));
            entry.setsID(Integer.valueOf(request.getParameter("sid")));
            entry.setEntryManager(request.getParameter("entrymanager"));
            entry.setEntryDate(new java.sql.Date(System.currentTimeMillis()));
            entry.seteCount(Integer.valueOf(request.getParameter("count")));
            entry.seteWay(request.getParameter("way"));
            entry.setDeal(true);
            entry.setVerify(true);
            entry.setPass(false);
            request.getSession().setAttribute("entry",entry);
            response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=1&flag=0");
        }else {
            Entry entry = (Entry)request.getSession().getAttribute("entry");
            entry.setgID(Integer.valueOf(request.getParameter("gid")));
            entry.setsID(Integer.valueOf(request.getParameter("sid")));
            entry.setEntryManager(request.getParameter("entrymanager"));
            entry.seteCount(Integer.valueOf(request.getParameter("count")));
            entry.seteWay(request.getParameter("way"));
            new EntryDao().insertEntry(entry);
            response.sendRedirect(request.getContextPath()+"/page/Master.jsp?index=1&flag=1");
        }
    }
}
