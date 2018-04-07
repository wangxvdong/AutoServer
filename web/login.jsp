<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/3/31
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <script src="JQueryMobile/jquery-3.3.1.min.js"></script>
    <script src="JQueryMobile/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="JQueryMobile/jquery.mobile-1.4.5.min.css">
    <script src="JQueryMobile/jquery.mobile-1.4.5.js"></script>

    <title>登录</title>
<%--<script>
    $(document).ready(function(){
        $("#submit").click(function () {
          $.ajax({
              type:"post",
              url:"ServletOfPage/ServletOfLogin",
              data:"username="+$("#username").val()+"&userpwd="+$("#userpwd").val()
          })
        })
    })
</script>--%>
</head>
<body>
<form action="ServletOfPage/ServletOfLogin" method="post">
    <div data-role="page">
        <div data-role="main" class="ui-content">
            <input type="text" id="username" data-inline="true" name="username" placeholder="请输入用户名。。。">
            <input type="password" id="userpwd" data-inline="true" name="userpwd" placeholder="请输入密码。。。">
            <input type="submit" id="submit" data-inline="true" value="登录" >
            <%--<input type="button" id="submit" data-inline="true" value="登录" onclick="window.location='/index.jsp';">--%>
            <%--<input type="submit" data-inline="true" value="登录" onclick="window.dialogArguments.open('/index.jsp')">--%>


        </div>


    </div>


</form>

</body>
</html>
