package com.zby.filter;

import com.zby.entity.User;
import com.zby.service.UserService;
import com.zby.service.impl.UserServiceImpl;
import com.zby.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //1.判断此人是否登陆，登录后可以进入查询页面，否则返回登录页面，从session中取user
        //filter中的ServletRequest是servlet中HttpServletRequest父类，要用到servlet中的req需要强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //放行不需要登录的页面，防止过滤器将登录页拦截
        String uri = request.getRequestURI();//先返回除去host（域名或者ip）部分的路径
//       uri =  uri.substring(uri.lastIndexOf("/"));

        if (uri.equals("/loginview") || uri.equals("/login") || uri.equals(".js") || uri.equals(".css")) { //判断是放行访问登录页和登录页和静态资源
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //判断用户是否为空
            if (user == null) {
                //未登录,获取cookie，判断cookie是否存在
                Cookie[] cookies = request.getCookies();
                Map<String, String> map = CookieUtil.cookiesToMap(cookies);
                String value = map.get("username");
                if (value == null) {
                    //未登录，cookie为空，还是在登录页面
                    response.sendRedirect("loginview");
                } else {
                    //虽然未登录，但cookie存在且未失效
                    //调用查询方法判断用户是否存在,得到用户，将用户存入session中
                    User userCookie = userService.getUserByUsername(value);
                    session.setAttribute("username", userCookie);
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                //登录放行
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
