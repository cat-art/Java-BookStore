<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <base href="http://localhost:8080/book/">
    <link rel="stylesheet" href="pages/login_page.css">

    <script>

    </script>
</head>
<body>
<div id="logo">
    <a href="#" title="化校" />
    <img src="img/4.jpg" height="100" width="100"/>
    </a>
</div>
<h1 id="header">
    化校网上二手书城
</h1>


<h1 class="login_header1">欢迎登录</h1>
<div class="content">
    <div class="errorMsg" style="color: #FF4400">
      <%--  <%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
        ${ empty requestScope.msg ? "请输入用户名和密码":requestScope.msg }
        </div>
    <div class="form">
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="login">
            <div >
                <a class="regist" href="pages/regist.jsp">立即注册</a> </div>
            <h3>化校书城会员</h3>
            <label for="username">用户名称:</label>
            <input  class="itxt" type="text" placeholder="请输入用户名"
                    autocomplete="=off" tabindex="1" name="username" id="username"
                    value="${requestScope.username}" />
            <br />
            <br />
            <label for="password">用户密码:</label>
            <input class="itxt" type="password" placeholder="请输入密码"
                   autocomplete="off" tabindex="1" name="password" id="password" />
            <br/>
            <br/>
            <input type="submit" value="登录" />
        </form>
    </div>
</div>
<div class="last">最终解释权归沈阳化工大学计算机学院@907372669.163.com</div>
</body>
</html>