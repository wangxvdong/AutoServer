<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/11
  Time: 21:16
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
        $(document).ready(function(){
        $("#submitr").click(function () {
        $.ajax({
        type:"post",
        url:"/ServletOfPage/ServletOfSearchRechargeRecharge",
        data:"p=1"
        })
        })
        })
</script>
    </head>
    <form action="/ServletOfPage/ServletOfSearchRechargeRecharge" method="post">
<body>
<div data-role="page" >
    <div data-role="main" class="ui-content">
        <input type="text" id="searchbox" name="searchbox" placeholder="请输入会员号或者手机号">

       <input type="button" id="submitr" value="Search">
        <%--<input type="submit" id="submitr" name="submit" value="搜索">--%>

    </div>
</div>
</body>
</form>
</html>