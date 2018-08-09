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

@WebServlet(name = "EntryServlet")
public class EntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("entry")==null) {
            Entry entry = new Entry();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssZ");

            entry.seteID(Integer.valueOf(format.format(date)));
            entry.setgID(Integer.valueOf(request.getParameter("")));
            entry.setsID(Integer.valueOf(request.getParameter("")));
            entry.setEntryManager(request.getParameter(""));
            entry.setEntryDate(new java.sql.Date(System.currentTimeMillis()));
            entry.seteCount(Integer.valueOf(request.getParameter("")));
            entry.seteWay(request.getParameter(""));
            entry.setDeal(true);
            entry.setVerify(true);
            entry.setPass(false);
            request.getSession().setAttribute("entry",entry);
            request.getRequestDispatcher("").forward(request,response);
        }else {
            new EntryDao().insertEntry((Entry) request.getSession().getAttribute("entry"));
        }
    }
}
