<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>manager_book</title>
    <base href="http://localhost:8080/book/">
    <link rel="stylesheet" href="pages/static_pages.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript">
        $(function() {
            //给删除绑定单击事件 用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                    return confirm("你确定要删除【"+ $(this).parent().parent().find("th:first").text() +"】??");
                });
        });
    </script>
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
    </style>
</head>
<body>

<!--        图书管理里面有一个表单项 其样式跟manager一致
        表单项里有书籍的名称 价格 作者 销量 库存 操作（修改 删除 增加）-->
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
        图书管理系统后台
    </h1>


    <div class="box">
        <div class="table">
            <table >
                <tr>
                    <th>书名</th>
                    <th>价格</th>
                    <th>作者</th>
                    <th>销量</th>
                    <th>库存</th>
                    <th colspan="2" align="center">操作</th>
                </tr>

                <c:forEach items="${requestScope.books}" var="book">
                <tr>
                <th>${book.name}</th>
                <th>${book.price}</th>
                <th>${book.author}</th>
                <th>${book.sales}</th>
                <th>${book.stock}</th>
                <th><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></th>
                <th><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></th>
            </tr>
                </c:forEach>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th colspan="2" align="center"><a href="pages/manager/book_editor.jsp?pageNo=${requestScope.page.pageTotal}">添加</a></th>
                </tr>
            </table>
        </div>
        <%--end-- table--%>
        <%--写分页的样式代码 静态--%>
      <%--  <div id="page_nav">
            <c:if test="${requestScope.page.pageNo > 1}">
                <a href="manager/bookServlet?action=page&pageNo=1">首页</a>
                <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>
            <a href="#">${requestScope.page.pageNo}</a>
            【${requestScope.page.pageNo}】
            <a href="#">${requestScope.page.pageNo+1}</a>

           <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
               <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
               <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">尾页</a>
            </c:if>

            共${requestScope.page.pageSize}页，共${requestScope.page.pageTotalCount}
            条记录 到第 <input value="${param.pageNo}" name="pn" id="pn_input" />页
            <input id="searchPageBtn" type="button" value="确定">

            <script type="text/javascript">
                $(function(){
                    //跳到指定的页码
                    $("#searchPageBtn").click(function () {
                        var pageNo = $("#pn_input").val();

                        location.href = "http://localhost:8080/book/manager/bookServlet?action=page&pageNo=" +pageNo;
                    });
                });
            </script>--%>

        </div>
        <%--end-- box--%>
    </div>
</body>
</html>