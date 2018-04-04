package com.aflying.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 会飞的狼 on 2018/4/4.
 */
public class AjaxAction extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        resp.setCharacterEncoding("UTF-8");
        String selected = req.getParameter("selected");
        PrintWriter out = resp.getWriter();

        out.println("<response>");
        if(selected.equals("1")) {
            out.println("<city>");
            out.println("<cityname>长沙</cityname>");
            out.println("<cityvalue>1</cityvalue>");
            out.println("</city>");
            out.println("<city>");
            out.println("<cityname>株州</cityname>");
            out.println("<cityvalue>2</cityvalue>");
            out.println("</city>");
        }else {
            out.println("<city>");
            out.println("<cityname>广州市天河区</cityname>");
            out.println("<cityvalue>2</cityvalue>");
            out.println("</city>");
            out.println("<city>");
            out.println("<cityname>广州市海珠区</cityname>");
            out.println("<cityvalue>1</cityvalue>");
            out.println("</city>");
        }
        out.println("</response>");
        out.flush();
        out.close();
    }
}
