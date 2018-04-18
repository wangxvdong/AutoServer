<%@ page import="BeanOfAuto.DBConnection" %>
<%@ page import="BeanOfAuto.CustomerManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/18
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/AutoServer/JQueryMobile/jquery-3.3.1.min.js"></script>
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.css">
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.js"></script>

    <title>Title</title>
</head>
<%
    String url = "jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
    String user = "bdm256530140";
    String pwddb = "datapwd123";
    DBConnection con = new DBConnection();
    con.ConnectDataBase(url,user,pwddb);
    CustomerManager cusm = new CustomerManager();
    cusm.initDBConnect(con.GetDBConnection());
    ResultSet rsem= cusm.listExpiryMember();
    String lis="";
    while(rsem.next())
    {
        lis+="<li>"+rsem.getString("name")+"  "+rsem.getString("cid")+"  "+rsem.getString("plate")+"  "+rsem.getString("btime")+"  "+rsem.getString("etime")+"</li>";
    }

%>
<body>
<div data-role="page">
    <div data-role="header">

    </div>
    <div data-role="main" class="ui-content">
        <ol data-role="listview">
<%=lis%>
        </ol>
    </div>
</div>
</body>
</html>
