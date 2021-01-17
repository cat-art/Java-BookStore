<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>manager</title>

    <base href="http://localhost:8080/book/">
    <link rel="stylesheet" href="pages/static_pages.css">

</head>
<body>
    <ul class="nav">
        <li>
            <%--+manager用来区分前后台地址--%>
            <a href="manager/bookServlet?action=list">图书管理</a>
        </li>
        <li>
            <a href="pages/cart/cart.jsp">订单管理</a>
        </li>
        <li>
            <a href="pages/index.jsp">返回商场</a>
        </li>
    </ul>
    <div>
    </div>
    <div class="index_logo">
        <a href="#"  title="化校">
            <img src="img/4.jpg" height="100" width="100"/> </a>
    </div>


    </div>
    <h1 id="index_header">
        图书管理系统后台
    </h1>
    <div class="box" >
            欢迎你！！
    </div>
</body>
</html>