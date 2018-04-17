<%@ page import="BeanOfAuto.CustomerOfVip" %><%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/11
  Time: 21:08
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

    <script>

    </script>

</head>
<form action="/ServletOfPage/ServletOfRecharge" method="post">
<body>
<%
    CustomerOfVip vp=(CustomerOfVip) request.getSession().getAttribute("searchboxrecharge");
    System.out.println(vp.name+vp.phone);
%>
<div data-role="page" >
    <div data-role="header" class="ui-header">
        <h1>会员充值</h1>
    </div>
    <div data-role="main" class="ui-content">
        <input type="text" value="<%=vp.id%>">
        <input type="text" value="<%=vp.name%>">
        <input type="text" value="<%=vp.p1num%>">
        <input type="text" value="<%=vp.p2num%>">
        <p>======================</p>
        <div data-role="collapsible">
            <h2>选择项目</h2>
            <ul data-role="listview" id="projecttype">
                <li><input type="radio" name="projecttype" id="ptnum1" value="洗车">洗车</li>
                <li><input type="radio" name="projecttype" id="ptnum2" value="打蜡">打蜡</li>
                <li><input type="radio" name="projecttype" id="ptnum3" value="去污">去污</li>
            </ul>
        </div>
        <div data-role="collapsible">
            <h2>选择数量</h2>

                <input type="number" name="projectcount"  placeholder="请输入数量。。。">

        </div>

        <input type="number" name="pocket" placeholder="实付款">
        <input type="number" name="payable" placeholder="应付款">
        <input type="submit" name="rechargesubmit"  value="充值">

    </div>
</div>
</body>
</form>
</html>
