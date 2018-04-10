<%@ page import="BeanOfAuto.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="BeanOfAuto.CustomerManager" %>
<%@ page import="BeanOfAuto.CustomerOfVip" %>
<%@ page import="java.util.ArrayList" %><%--
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

    <%@ page isELIgnored="false" %>

    <script>
        $(document).ready(function() {
            $("#submit").click(function () {
                $.ajax({
                    type: "post",
                    url: "ServletOfPage/TestServlet",
                    data: "searchbox=" + $("#searchbox").val() + "&pagemsg=search"
                    success:function () {
                        alert('asdfasdf')
                    }

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

<%
   // response.setHeader("refresh" , "3" );
    CustomerOfVip vippnum=(CustomerOfVip) request.getSession().getAttribute("projectnum");
%>




    <input type="text"  id="p1num" value="<%=vippnum.p1num%>">
    <input type="text"  id="p2num" value="<%=vippnum.p2num%>">
    <input type="text"  id="p3num" value="<%=vippnum.p3num%>">
    <div data-role="collapsible">
        <h2>选择项目</h2>
        <ul data-role="listview" id="projecttype" name="projecttypelist">
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
     DBConnection con = new DBConnection();
    String url = "jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
    String user = "bdm256530140";
    String pwddb = "datapwd123";
    try {
    con.ConnectDataBase(url, user, pwddb);
    } catch (ClassNotFoundException e) {
    e.printStackTrace();
    } catch (SQLException e) {
    e.printStackTrace();
    } catch (InstantiationException e) {
    e.printStackTrace();
    } catch (IllegalAccessException e) {
    e.printStackTrace();
    }



    CustomerManager cm = new CustomerManager();
    cm.initDBConnect(con.GetDBConnection());
    try {
        String sb = request.getParameter("searchbox").toString();
    ArrayList al = cm.GetCustomerInfoS(sb); // 只取出单条客户记录,尽快改成多条可选择方式!!!
    if (sb != null)
    if (!sb.isEmpty()) {
        CustomerOfVip cvp = ((CustomerOfVip) al.get(0));
        request.setAttribute("xcnum", cvp.p1num);
        request.getSession().setAttribute("dlnum", cvp.p2num);
        request.setAttribute("qunum", cvp.p3num);




    }
    } catch (SQLException e) {
    e.printStackTrace();

    }*/
%>
</html>
