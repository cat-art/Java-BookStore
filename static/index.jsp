<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网上书城</title>
</head>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link rel="stylesheet" href="pages/index_page.css">
<body>
        <ul class="nav">
            <li>
                <a href="pages/login.jsp">登录</a>
            </li>
            <li>
                <a href="pages/regist.jsp">注册</a>
            </li>
            <li>
                <a href="pages/cart/cart.html">购物车</a>
            </li>
            <li>
                <a href="pages/order/manager.jsp">管理后台</a>
            </li>
        </ul>
        <div class="index_logo">
            <a href="#"  title="化校">
                <img src="img/4.jpg" height="100" width="100"/></a>
        </div>

        <h1 id="index_header">
            化校网上二手书城
        </h1>

            <div class="form_index">
                <form action="#">
                    <div class="top_content">
                    <label for="">价格:</label>
                    <input type="text">元-
                    <input type="text">元
                    <input type="submit" value="查询">
                    <div>您的购物车有n件商品</div>
                    <div>您刚刚将
                        <label for=""> &nbsp 哈利波特 &nbsp</label>
                        加入到购物车</div>
                    </div>
                    <table class="table_index1" >
                         <tr>
                             <th><label for="">书名:哈利波特</label> <br>
                                 <label for="">价格:180.00元</label>
                                 <img src="img/index4.png" height="230" width="180"/>
                                 <button>加入购物车</button>
                             </th>
                         </tr>
                    </table>
                    <table class="table_index2">
                        <tr>
                            <th>
                                <label>书名:小熊和最好的爸爸</label> <br>
                                <label for="">价格:38.00元</label>
                                <img src="img/index1.png" height="230" width="180"/>
                                <button>加入购物车</button>
                            </th>
                        </tr>
                    </table>
                    <table class="table_index3">
                        <tr>
                            <th><label for="">书名:侦探与小偷 </label> <br>
                                <label for="">价格:48.00元</label>
                                <img src="img/index2.png" height="230" width="180"/>
                                <button>加入购物车</button>
                            </th>
                        </tr>
                    </table>
                    <table class="table_index4">
                        <tr>
                            <th>
                                <label for="">书名:流浪地球</label> <br>
                                <label for="">价格:59.00元</label>
                                <img src="img/index3.png" height="230" width="180"/>
                                <button>加入购物车</button>
                            </th>
                        </tr>
                    </table>
                </form>
                <%--写分页的样式代码 静态--%>
                <div id="page_nav">
                    <a href="#">首页</a>
                    <a href="#">上一页</a>
                    <a href="#">3</a>
                    【4】
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">尾页</a>
                    共五页，5条记录 到第 <input value="4" name="pn" id="pn_input" />页
                    <input type="button" value="确定">
                </div>
            </div>
        <%--end--form-index--%>
            <div class="last">
                最终解释权归沈阳化工大学计算机学院@907372669.163.com
            </div>
</body>
</html>
