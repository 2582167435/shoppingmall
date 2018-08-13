package com.filter;

import com.Dao.OutDao;
import com.com.bean.Out;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "OutFilter",urlPatterns = "/page/Home.jsp")
public class OutFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getSession().getAttribute("outlist") == null){
            System.out.println("1");
            List<Out> list = new OutDao().getOut("isdeal",true);
            System.out.println(list.size());
            request.getSession().setAttribute("outlist",list);
            chain.doFilter(request,response);
        }else {
            chain.doFilter(request,response);
        }
    }
}
