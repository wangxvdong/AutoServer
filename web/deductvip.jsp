<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/8
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/JQueryMobile/jquery-3.3.1.min.js"></script>
    <script src="/JQueryMobile/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="/JQueryMobile/jquery.mobile-1.4.5.min.css">
    <script src="/JQueryMobile/jquery.mobile-1.4.5.js"></script>


    <title>Title</title>
</head>
<form action="/ServletOfPage/ServletOfDeductVip" method="post">
<body>
<div data-role="page">
    <div data-role="main" class="ui-content">
        <p>hello deduct!!!</p>
    </div>
</div>
</body>
</form>
<%
    System.out.println(request.getSession().getAttribute("searchvip").toString());
%>
</html>
