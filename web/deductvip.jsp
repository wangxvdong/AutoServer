<%@ page import="BeanOfAuto.CustomerOfVip" %><%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/4/8
  Time: 20:54
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
    <%
      //  CustomerOfVip cp= ((CustomerOfVip)request.getSession().getAttribute("searchvip"));
     //   System.out.println("deductvip===="+cp.name);
      // request.getRequestDispatcher("/AutoServer/ServletOfPage/ServletOfDeductVip").forward(request,response);
    %>

    <script>

              /*  $(document).on("pagebeforecreate",function(){
                    $.ajax({
                        type:"post",
                        url:"/AutoServer/ServletOfPage/ServletOfDeductVip",
                        data:"pagemsg='pageinit'"
                    })
                })*/
                /*$(document).on("pagecreate",function(){
                    alert("pagecreate 事件触发 - 页面已经创建，但还未增强完成");
                });*/

            $(document).ready(function(){
                $("#submitd").click(function () {
                  $.ajax({
                      type:"post",
                      url:"http://localhost:8080/AutoServer/ServletOfPage/ServletOfDeductVip.classs",
                      data:"projecttype="+$("#projecttype").val()+"&projectcount="+$("#projectcount").val()
                  })
                })
            })
</script>

</head>
<form action="/AutoServer/ServletOfPage/ServletOfDeductVip" method="post">
<body>
<%
    request.getSession().setAttribute("deductviphasruned",true);
    CustomerOfVip cp= ((CustomerOfVip)request.getSession().getAttribute("searchvip"));
    System.out.println(cp.name);
%>
<div data-role="page">
    <div data-role="main" class="ui-content">
       <input type="text" readonly="readonly" id="p1num" value="<%=cp.p1num%>">
       <input type="text" readonly="readonly" id="p2num" value="<%=cp.p2num%>">
       <input type="text" readonly="readonly" id="p3num" value="<%=cp.p3num%>">
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
        <%--<input type="button" id="submitd" value="提交" >--%>
        <input type="submit" id="dsubmit" value="确认submit">

    </div>
</div>
</body>
</form>

</html>
