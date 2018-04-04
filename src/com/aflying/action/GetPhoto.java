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
public class GetPhoto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");
        PrintWriter out = resp.getWriter();
        String selected = req.getParameter("selected");

        String[] photos = {"images/6.gif","images/2.gif","images/6.gif","images/4.gif","images/5.gif"};
        int index = Integer.parseInt(selected);
        out.println(photos[index]);
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
