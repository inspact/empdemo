package com.zby.servlet;

import com.google.gson.Gson;
import com.zby.entity.User;
import com.zby.service.UserService;
import com.zby.service.impl.UserServiceImpl;
import com.zby.vo.LoginVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //json输需要响应格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();


        //1.得到表单中的username和password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.通过用户名查询用户是否存在、是否正确
        User user = userService.getUserByUsername(username);
        //登陆成功
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //过滤器需要判断用户是否登录，首先需要存入用户名和密码
                //从session中获得user,利用session可以保持一次会话内用户名密码一直存在
                //登录成功将用户名和密码存入到session中，这样跳转其它页面还有登录信息，但要在重定向前存入
                HttpSession session = req.getSession();
                session.setAttribute("user", user);


                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setMaxAge(60 * 60 * 24);
                //cookie存入浏览器
                resp.addCookie(cookie);
                LoginVO loginVO = LoginVO.success();
                //响应到前台
                String jsonstr = new Gson().toJson(loginVO);
                out.print(jsonstr);
//                resp.sendRedirect("empList");
            } else {
                //密码错误
                LoginVO loginVO = LoginVO.error(1, "密码错误");
                String jsonstr = new Gson().toJson(loginVO);
                out.print(jsonstr);

            }


        } else {
            //用户名不存在
            //   resp.sendRedirect("loginview");

            LoginVO loginVO = LoginVO.error(2, "用户名不存在");
            String jsonstr = new Gson().toJson(loginVO);
            out.print(jsonstr);

        }

    }
}
