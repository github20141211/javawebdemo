<%@page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="JSONRPCBridge" scope="session" class="com.metaparadigm.jsonrpc.JSONRPCServlet"/>
<jsp:useBean id="hello" class="com.aflying.bean.TestBean"></jsp:useBean>
<%
    com.metaparadigm.jsonrpc.JSONRPCBridge.registerObject("jsHello", hello);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jsonrpc.js"></script>
    <script language="JavaScript">
        jsonrpc = new JSONRpcClient("JSON-RPC");
        function callServer() {
            myName = document.all.userName.value;
            if(myName == "") {
                alert("�Բ���������������");
                return ;
            }

            alert(jsonrpc.jsHello.sayHello(myName));
        }
        function calc() {
            arg0=document.all.value;
            arg1=document.all.unit.value;
            if(arg0 == "") {
                alert("�Բ�����������Բ�뾶");
                return ;
            }
            if(arg1 == "") {
                alert("�Բ�����������Բ�뾶�ĵ�λ��");
                return ;
            }
            result = jsonrpc.jsHello.circleArea(arg0 *1, arg1);
            document.all.area.value = result;
        }

        function getNow() {
            result = jsonrpc.jsHello.serverDate();
            document.all.now.value = result;
            arg0=document.all.row.value;
            arg1=document.all.col.value;
            if(arg0 == "") {
                alert("�Բ���������������");
                return ;
            }
            if(arg1 == "") {
                alert("�Բ���������������");
                return ;
            }

            result = jsnrpc.jsHello.strArray(arg0, arg1);
            for(var i=0; i<result.length; i++) {
                tableRow = document.all.table1.insertRow(-1);
                for(var j=0; j<result[i].length; j++) {
                    tableCell = tableRow.insertCell(-1);
                    tableCell.innerHTML = result[i][j];
                }
            }
        }
    </script>
</head>
<body>
    <h2>JSON-RPCʵ��</h2>
    ������������<input type="text" id="userName">
    <input type="button" value="�ʺ�" onclick="callServer()"><br><br>
    ������Բ�İ뾶��<input type="text" id="r" size="6">
    ��λ��<input type="text" id="unit" size="4">
    ���Ϊ��<input type="text" id="area" readonly= "true" size="12">
    <input type="button" value="����" onclick="calc()"><br><br>

    ��������ǰʱ�䣺<input type="text" id="now" readonly= "true" size="30">
    <input type="button" value="ȡ��ʱ��" onclick="getNow()"><br><br>

    �����������������
    <input type="text" id="row" size="4">��
    <input type="text" id="col" size="4">��

    <input type="button" value="���ɱ��" onclick="createTable()"><br>
    <table id="table1" border="1" width="500" bgcolor="#eeeeee"></table><br>
</body>
</html>












