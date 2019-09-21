package com.zby.servlet;

import com.zby.entity.User;
import com.zby.service.UserService;
import com.zby.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.得到表单中的username和password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.通过用户名查询用户是否存在、是否正确
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)){

            //过滤器需要判断用户是否登录，首先需要存入用户名和密码
            //从session中获得user,利用session可以保持一次会话内用户名密码一直存在
            //登录成功将用户名和密码存入到session中，这样跳转其它页面还有登录信息，但要在重定向前存入
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            Cookie cookie = new Cookie("username",user.getUsername());
            cookie.setMaxAge(60*60*24);
            //cookie存入浏览器
            resp.addCookie(cookie);

            resp.sendRedirect("empList");

        }else {
            resp.sendRedirect("loginview");
        }

    }
}
