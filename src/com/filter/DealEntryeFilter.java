package com.filter;

import com.Dao.EntryDao;
import com.com.bean.Entry;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "DealEntryeFilter")
public class DealEntryeFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Entry> list = new EntryDao().getEntry();
        session.setAttribute("entrylist",list);
       chain.doFilter(request,response);
    }
}
