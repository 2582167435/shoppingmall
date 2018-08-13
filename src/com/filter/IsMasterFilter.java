package com.filter;

import com.Dao.EntryDao;
import com.Dao.UserDao;
import com.com.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "IsMasterFilter",urlPatterns = "/page/Master.jsp")
public class IsMasterFilter extends HttpFilter {


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (new UserDao().checkMaster( (String)request.getSession().getAttribute("userName"))){
            if (request.getSession().getAttribute("masterindex")==null)
            {
                request.getSession().setAttribute("masterindex",request.getParameter("index"));
            }
            if (request.getSession().getAttribute("entrylist")==null){
                request.getSession().setAttribute("entrylist",new EntryDao().getEntry());
            }
            chain.doFilter(request,response);
        }else {
            response.sendRedirect("/page/Home.jsp");
        }
    }

}
