<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/4/1
  Time: 16:34
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
    <title>注册会员</title>

    <script>
    function viptyperadio()
    {
    //document.getElementById("vipcontext").innerHTML="0009998988";
    var radios= document.getElementsByName("limittype");
    //var xr=XMLHttpRequest();
    for(var i=0,length=radios.length;i<length;i++)
    {
    if(radios[i].checked)
    {
    // alert(radios[i].value);
    if(radios[i].value=="number")
    {

    //xr.open("GET","viptypenumber",true);
    //xr.send();

    var xmlhttp;
    if (window.XMLHttpRequest)
    {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
    }
    else
    {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("vipcontext").innerHTML=xmlhttp.responseText;
    }
    }
    xmlhttp.open("GET","viptypenumber0",true);
    xmlhttp.send();
    }
    else if(radios[i].value=="time")
    {
    //xr.open("GET","viptypenumber",true);
    //xr.send();

    var xmlhttp;
    if (window.XMLHttpRequest)
    {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
    }
    else
    {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("vipcontext").innerHTML=xmlhttp.responseText;
    }
    }
    xmlhttp.open("GET","viptypenumber1",true);
    xmlhttp.send();

    }
    break;
    }
    }
    // alert(xr.responseText);
    document.getElementById("vipcontext").innerHTML=xr.responseText;
    //"<input type=text value=asf />";

    }
    </script>

</head>
<body>
<form action="ServletOfPage/RegisterOfVip" method="post">
    <div data-role="page">
        <div data-role="main" class="ui-content">


            称呼 　　<input type=text name="name"></input><br>
            车牌号　<input type=text name=plate></input><br>
            联系方式<input type=text name=contact></input><br>
            车型　　<input type=text name=cartype></input><br>
            会员类型
            <label for="vltn">次卡</label>
            <input type="radio" name="limittype" id="vltn" value="number" onclick=viptyperadio()>
            <label for="vltt">时卡</label>
            <input type="radio" name="limittype" id="vltt" value="time" onclick=viptyperadio()>
            <br>
            <div id=vipcontext>...</div>
            <input type="date" name=regtime value=${sessionScope.nowdate}>
            <%--<input type="date" name=regtime value=<%=nowdate %>>--%>
            <input type="number" name="pocket" placeholder="实付款">
            <input type="number" name="payable" placeholder="应付款">
            <input type="submit" value="录入">





        </div>


    </div>


</form>
</body>
</html>
