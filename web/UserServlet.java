package com.bookStore.web;

import com.bookStore.pojo.User;
import com.bookStore.service.UserService;
import com.bookStore.service.impl.UserServiceImpl;
import com.bookStore.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用userService.existUsername();
        boolean existUsername = userService.existUsername(username);
        //把返回的结果封装称为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }


    /**
     * 处理注册的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //  1 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 2 检查 验证码是否正确
        if("12345".equalsIgnoreCase(code))
        {
            //3 检查 用户名是否可用
            if(userService.existUsername(username))
            {
                //把回显信息保存到reqest域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //存在不可用
                System.out.println("用户名已存在!!!" + username);
                //跳回注册页面
                req.getRequestDispatcher("pages/regist.jsp").forward(req,resp);
            }else
            {
                userService.registUser(new User(null,username,password,email));
                //可用   调用Service保存到数据库
                //跳回到注册成功的界面 regin_success.html
                req.getRequestDispatcher("pages/login.jsp").forward(req,resp);
            }
        }else
        {
            req.setAttribute("msg","验证码错误!!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            //跳回注册页面  验证码错误
            System.out.println("验证码错误");
            req.getRequestDispatcher("pages/regist.jsp").forward(req,resp);
        }



    }
    /**
     * 处理登录的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //层层优化之后最优雅的代码! 耗时5个小时找bug 细心!!!
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        /**
         * 登录要做的操作就是检查 用户名和密码是否正确 正确 跳转到 网上书城.html
         * 如果用户名和密码错误则跳转到 登录界面
         */
        if (userService.login(new User(null,username, password,null)) == null) {
            // 把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳回登录页面
            System.out.println("用户名和密码错误!!");
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("pages/index.jsp").forward(req, resp);
        }
    }
}
