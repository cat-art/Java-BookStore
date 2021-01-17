<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>

    <base href="http://localhost:8080/book/">
    <link rel="stylesheet" href="pages/static_pages.css">
    <title>book_editor</title>
    <style type="text/css">
        .table {
            /*表格居中*/
            margin: 0 auto;
            margin-top: 40px;
            width: 1000px;
            border: 1px solid green;

            border-left: 0px;
            border-right:0px;
            cellspacing:0px;
        }
        /*,表示并集*/
        table,tr {
            width: 1000px;
        }
        th {
            padding-top: 10px;
            padding-bottom: 10px;
            border-style: solid;
            border-left: 0px;
            border-right:0px;
            border-bottom: 1px;
            cellspacing:0px;
        }
        input {
            font-size: 10px;
            height: 20px;
        }
    </style>
</head>
<body>
<ul class="nav">
    <li>
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
        <img src="  img/4.jpg" height="100" width="100"/> </a>
</div>


</div>
<h1 id="index_header">
    编辑图书
</h1>
<div class="box" >
    <div class="table">
        <table>
            <tr>
                <th>书名</th>
                <th>价格</th>
                <th>作者</th>
                <th>销量</th>
                <th>库存</th>
                <th colspan="2">操作</th>

            </tr>
            <form action="manager/bookServlet" method="post" class="input">
               <%-- <input type="hidden" name="pageNo" value="${param.pageNo}" />--%>
                <input type="hidden" name="action" value="${empty param.id?"add":"update"}" />
                <input type="hidden" name="id" value="${requestScope.book.id}" />
                <tr>
                    <th><input type="text" name="name" value="${requestScope.book.name}"></th>
                    <th><input type="text" name="price" value="${requestScope.book.price}"></th>
                    <th><input type="text" name="author" value="${requestScope.book.author}"></th>
                    <th><input type="text" name="sales" value="${requestScope.book.sales}"></th>
                    <th><input type="text" name="stock" value="${requestScope.book.stock}"></th>
                    <th><input type="submit" value="提交" ></th>
                </tr>
            </form>
        </table>
    </div>
</div>

</body>
</html>