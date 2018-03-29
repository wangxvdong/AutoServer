<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2018/3/20
  Time: 22:19
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

    <title>###汽车服务有限公司</title>
  </head>

  <body>
  <form action="ServletOfPage/ServletAtIndex" method="post">
  <div data-role="page" id="pageone">
    <div data-role="header">
      <h1>欢迎访问我的主页</h1>
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
      <a href="#pagetwo">跳转到第一个页面</a>
    </div>
    <div data-role="footer">
    <h2>Github is ready</h2>
    <input type="submit" value="提交">
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
