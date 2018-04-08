<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/8
  Time: 20:44
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


   <%-- <script>
        $(document).ready(function(){
            $("#submit").click(function () {
                $.ajax({
                    type:"post",
                    url:"ServletOfPage/TestServlet",
                    data:"buttonname=submit&searchvip="+$("#searchbox").val()
                })
            })
        })
    </script>--%>
</head>
<form action="ServletOfPage/TestServlet" method="post">
<body>
<div data-role="page" >
    <div data-role="main" class="ui-content">
        <input type="text" id="searchbox" name="searchbox" placeholder="请输入会员号或者手机号">
        <input type="submit" id="submit" name="submit" value="搜索">
    </div>
</div>
</body>
</form>
<%

/*

        if((request.getSession().getAttribute("isfirstrunofsearchvip").toString().equals("true"))) {
            request.getSession().setAttribute("isfirstrunofsearchvip", "false");
        }
            else{
                String result = request.getParameter("buttonname").toString();
                String sb = request.getParameter("searchvip").toString();

                if (result != null && sb != null)
                    if (result.equals("submit") && !sb.isEmpty()) {


                        request.getSession().setAttribute("searchvip", sb);
                        response.sendRedirect("/deductvip.jsp");
                        return;
                    }

        }*/
%>
</html>
