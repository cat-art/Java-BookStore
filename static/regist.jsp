<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <base href="http://localhost:8080/book/">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <link rel="stylesheet" href="pages/regist-page.css">
    <script>

        $(function() {
            $("#username").blur(function() {
                //获取用户名
                var username = this.value;

                $.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username=" +username,function (data) {
                 //       if(data.existsUsername) {
                          $("span.errorMsg").text("温馨提示:用户名已存在!");
               //       } else {
            //             $("span.errorMsg").text("温馨提示:用户名可用");
              //        }
                });
            });



           //给注册绑定单击事件
            $("#sub_btn").click(function() {
                var usernameText = $("#username").val();  //获取用户表达式的值
                var usernamePatt = /^\w{5,12}$/;
                if(!usernamePatt.test(usernameText)) {
                    //提示用户结果
                    $("span.errorMsg").text("用户不合法!!");
                    return false;
                }

                var passwordText = $("#password").val();  //获取密码表达式的值
                var passwordPatt = /^\w{5,12}$/;
                if(!passwordPatt.test(passwordText)) {
                    //提示用户结果
                    $("span.errorMsg").text("密码不合法!!");
                    return false;
                }

                var repwdText = $("#repwd").val();     //获取确认密码表达式

                if(repwdText != passwordText) {
                    $("span.errorMsg").text("密码与确认密码不一致");
                    return false;
                }

                //邮箱的验证
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if(!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("邮箱地址不正确!!!");
                    return false;
                }
                $("span.errorMsg").text("");

            });
        });
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

        <div>
            <div class="login_banner">
                <div id="1_content">
                    <span class="login_word">欢迎注册</span>
                </div>
            </div>
        </div>

        <div id="content">
            <div class="login_form">
                <div class="login_box">
                    <div class="form">
                        <span class="errorMsg">
                            ${requestScope.msg}
                        </span>
                        <form action="userServlet" method="post">
                            <input type="hidden" name="action" value="regist">
                          <!--  <div class="tit">
                                <h2 >注册为会员</h2>
                            </div>-->
                            <label>用户名称:</label>
                            <input  class="itxt" type="text" placeholder="请输入用户名"
                                    autocomplete="=off" tabindex="1" name="username" id="username"
                                    value="${requestScope.username}"
                            />
                            <br />
                            <br />
                            <label>用户密码:</label>
                            <input class="itxt" type="password" placeholder="请输入密码"
                            autocomplete="off" tabindex="1" name="password" id="password" />
                            <br />
                            <br />
                            <label>确认密码:</label>
                            <input class="itxt" type="password" placeholder="确认密码"
                                   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                            <br />
                            <br />
                            <label>电子邮件:</label>
                            <input class="itxt" type="text" placeholder="请输入邮箱地址"
                            autocomplete="off" tabindex="1" name="email" id="email"
                                   value="${requestScope.email}"
                            />
                            <br />
                            <br />
                            <label>验证码:</label>
                            <input class="itxt" type="text" id="code" name="code" />
                            <img src="../img/133.png" width="28" height="18" alt="">  <!--插入验证码的图片-->
                            <br />
                            <br />
                            <input type="submit" value="注册" id="sub_btn" />

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="last">最终解释权归沈阳化工大学计算机学院@907372669.163.com</div>
</body>
</html>