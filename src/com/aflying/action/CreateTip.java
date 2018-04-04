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
public class CreateTip extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String[][] shop = {{"商品一", "90", "images/0.gif"},
              {"商品二", "90", "images/1.gif"},
              {"商品三", "90", "images/2.gif"}};

      int index = Integer.parseInt(req.getParameter("index"));
      resp.setContentType("text/xml");
      resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<shop>");
        out.println("<name>" + shop[index][0]+ "</name>");
        out.println("<price>" + shop[index][1]+ "</price>");
        out.println("<photo>" + shop[index][2]+ "</photo>");
        out.println("</shop>");
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
