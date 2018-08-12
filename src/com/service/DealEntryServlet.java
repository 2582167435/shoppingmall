package com.service;

import com.com.bean.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DealEntryServlet")
public class DealEntryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("isdeal") == null){
            int index = Integer.valueOf(request.getParameter("index"));
            request.setAttribute("entry",((List<Entry>)request.getSession().getAttribute("entrylist")).get(index));
            request.getRequestDispatcher("/EntryServlet").forward(request,response);
        }else {

        }

    }
}
