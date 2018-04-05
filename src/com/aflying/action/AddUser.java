package com.aflying.action;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 会飞的狼 on 2018/4/4.
 */
public class AddUser extends HttpServlet {
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
       StringBuffer json = new StringBuffer();
       String line = null;
        BufferedReader reader = req.getReader();
        while((line= reader.readLine()) != null) {
            line = new String(line.getBytes("ISO8859-1"), "UTF-8");
            json.append(line);
        }
        //JSONObject jsonObject = null;
        JSONObject jsonObject = null;
        try{
            //jsonObject = new JSONObject(json.toString());
            jsonObject = JSONObject.parseObject(json.toString());
            System.out.println(jsonObject);

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        String userName, password, department, headship,sex, old;
        try {
            userName = jsonObject.getString("userName").toUpperCase();
            password = jsonObject.getString("password");
            department = jsonObject.getString("department").toUpperCase();
            headship = jsonObject.getString("headship").toUpperCase();
            sex = jsonObject.getString("sex");
            old = jsonObject.getString("old") + "岁";
            if(sex.equals("1")) {
                userName = userName + "先生";
                sex = "男";
            }else {
                userName = userName + "女士";
                sex = "女";
            }

            jsonObject.put("userName", userName);
            jsonObject.put("password", password);
            jsonObject.put("department", department);
            jsonObject.put("headship", headship);
            jsonObject.put("sex", sex);
            jsonObject.put("old", old);
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("GB2312");
        PrintWriter out = resp.getWriter();
        out.println(jsonObject.toString());
        out.flush();
        out.close();
    }
}
