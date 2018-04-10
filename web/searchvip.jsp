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
    <script src="/AutoServer/JQueryMobile/jquery-3.3.1.min.js"></script>
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.css">
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.js"></script>
    <title>Title</title>


    <script>
        $(document).ready(function() {
            $("#submit").click(function () {
                $.ajax({
                    type: "post",
                    url: "ServletOfPage/TestServlet",
                    data: "searchbox=" + $("#searchbox").val() + "&pagemsg=search"
                })
            })
        })
         $(document).ready(function(){
            $("#submitd").click(function () {
                $.ajax({
                    type:"post",
                    url:"ServletOfPage/TestServlet",
                    // $("input[name='radio']:checked").val()
                    data:"pagemsg=searchd&projecttype="+$("input[name='projecttype']:checked").val()+"&projectcount="+$("input[name='projectcount']:checked").val()
                })
            })
        })
    </script>
</head>
<form action="ServletOfPage/TestServlet" method="post">
<body>
<div data-role="page" >
    <div data-role="main" class="ui-content">
        <input type="text" id="searchbox" name="searchbox" placeholder="请输入会员号或者手机号">

        <input type="submit" id="submit" name="submit" value="搜索">
    </div>






    <input type="text" readonly="readonly" id="p2num" value="${cp.p2num}">
    <input type="text" readonly="readonly" id="p3num" value="${cp.p3num}">
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
        <ul data-role="listview" id="projectcount">
            <li><input type="radio" name="projectcount"  value="1">1</li>
            <li><input type="radio" name="projectcount"  value="2">2</li>
            <li><input type="radio" name="projectcount"  value="3">3</li>
        </ul>
    </div>
    <input type="button" id="submitd" value="提交" >
    <input type="submit" id="dsubmit" value="确认submit">
    <%

    %>
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
