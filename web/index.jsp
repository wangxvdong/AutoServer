<%@ page import="ServletOfPage.ServletAtIndex" %>
<%@ page import="Bean.PageBean" %>
<%@ page import="java.net.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/3/20
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <jsp:useBean id="name" scope="page" class="Bean.PageBean"></jsp:useBean>
    <meta name="viewport" content="width=device-width,initial-scale=1">

<%--<script src="/JQueryMobile/jquery-3.3.1.min.js"></script>--%>
    <%--<script src="/JQueryMobile/jquery.mobile-1.4.5.min.js"></script>--%>
    <%--<link rel="stylesheet" href="/JQueryMobile/jquery.mobile-1.4.5.min.css">--%>
    <%--<script src="/JQueryMobile/jquery.mobile-1.4.5.js"></script>--%>
    <script src="/AutoServer/JQueryMobile/jquery-3.3.1.min.js"></script>
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.min.css">
    <script src="/AutoServer/JQueryMobile/jquery.mobile-1.4.5.js"></script>

    <title>###汽车服务有限公司</title>

      <script>
          $(document).ready(function(){
              $("#submitindex").click(function () {
                  $.ajax({
                      type:"post",
                      url:"ServletOfPage/ServletAtIndex",
                      data:"username"
                  })
              })
          })
      </script>
  </head>


  <body>
  <form action="ServletOfPage/ServletAtIndex" method="post">
  <div data-role="page" id="pageone">
    <div data-role="header">
      <a href="/index.jsp" class="ui-btn ui-icon-home ui-btn-icon-left">主页</a>
      <h1>欢迎访问我的主页</h1>
      <%
        PageBean p=(PageBean) request.getSession().getAttribute("username_");
          if(p==null) {
              p = new PageBean();
              p.setUsername_("登录");
          Cookie[] cook= request.getCookies();
          if(cook!=null)
              for (Cookie c:cook) {
                  if (c.getName().equals("fircook"))
                      out.println(c.getValue().toString());
              }
                //  String sc=request.getSession().getAttribute("firuser").toString();
//        String  s=new String( request.getSession().getAttribute("username_").toString());

          if(request.getSession().getAttribute("firuser")==null)
              ;
          else
          {

          }





        }
          String path = request.getContextPath();
          String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
      %>

      <%--<a href="/login.jsp" class="ui-btn ui-icon-user ui-btn-icon-left" name="username"><%=p.getUsername()%></a>--%>

        <button  id="login" class="ui-btn ui-icon-user ui-btn-icon-left" name="username" onClick="window.location='<%=basePath%>login.jsp'"><%=p.getUsername()%></button>
      <div data-role="navbar">
        <ul>
          <li><a href="#anylink" data-icon="home">首页</a></li>
          <li><a href="#anylink">页面二</a></li>
          <li><a href="#anylink">搜索</a></li>
        </ul>
      </div>
    </div>

    <div data-role="main" class="ui-content">
      <p>i am a mobile webpage programer</p>
        <button onclick="window.location.href='/registervip.jsp'">注册会员</button>
        <button onclick="window.location.href='/AutoServer/searchvip.jsp'">会员扣次</button>
      <a href="/AutoServer/searchrecharge.jsp" class="button">会员充值</a>
        <%--<a href="registervip.jsp" id="regviplink">注册会员</a>--%>
        <input type="button" id="submitindex" value="提交">
      <%--<jsp:forward page="login.jsp">跳转</jsp:forward>--%>
      <a href="/index.jsp#pagetwo">跳转到第一个页面</a>
    </div>
    <div data-role="footer">
    <h2>Github is ready</h2>

    </div>
  </div>



    <div data-role="page" id="pagetwo">
      <div data-role="header">
        <h1>欢迎来到我的主页</h1>
      </div>

      <div data-role="main" class="ui-content">
        <p>这是第二个页面。点击以下链接跳转到第一个页面。</p>
        <a href="#pageone">跳转到第一个页面</a>
      </div>

      <div data-role="footer">
        <h1>底部文本</h1>
      </div>
    </div>


  </form>
  </body>
</html>
