<%--
  Created by IntelliJ IDEA.
  User: luocheng
  Date: 2018/4/4
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax测试</title>
    <script type="text/javascript" src="/js/select.js"></script>
  </head>
  <body>
  Hello JavaWeb
  <br/>
  请选择省份
  <select name="selected" id="slt1" onChange="updateSelect()">
    <option value="1">湖南省</option>
    <option value="2">广东省</option>
  </select>
  地市：
  <select id="slt2">
    <option value="">请选择地市</option>
  </select>
  </body>
</html>
