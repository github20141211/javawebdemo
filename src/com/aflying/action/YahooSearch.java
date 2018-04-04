package com.aflying.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author 会飞的狼 on 2018/4/4.
 */
public class YahooSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String baseUrl = "http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid=YahooDemo&ei=UTF-8&&type=all";
      String query = req.getParameter("query");

      query = new String(query.getBytes("ISO8859-1"), "GB2312");
      query = URLEncoder.encode(query, "UTF-8");

      query = "&query=" + query;

      String results = req.getParameter("results");
      results = "&results=" + results;
      String url = baseUrl + query + results;

        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("GET");
        resp.setContentType("text/xml");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = null;
        while((line = reader.readLine()) != null) {
            line = new String(line.getBytes(), "UTF-8");
            out.println(line);
        }
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
