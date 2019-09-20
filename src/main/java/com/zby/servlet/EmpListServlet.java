package com.zby.servlet;

import com.zby.entity.Emp;
import com.zby.service.EmpService;
import com.zby.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/empList"})
public class EmpListServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();


    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.查询数据库
        List<Emp> empList = empService.listEmpDept();
        //2.把数据绑定到req,得到数据
        req.setAttribute("empList",empList);

        //3.转发到jsp上
        req.getRequestDispatcher("\\WEB-INF\\pages\\emplist.jsp").forward(req,resp);
    }
}














