package com.aflying.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author 会飞的狼 on 2018/4/4.
 */
public class UpdateCounter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/xml");
       resp.setCharacterEncoding("UTF-8");
       PrintWriter out = resp.getWriter();
       Random rnd = new Random();
       out.println("<response>");
        for (int i = 0; i < 6; i++) {
            out.println("<counter>" + rnd.nextInt(100) + "</counter>");
        }
        out.println("</response>");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
