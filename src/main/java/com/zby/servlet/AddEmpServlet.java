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
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/addemp"})
public class AddEmpServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");

        //1.获得表单数据
        Emp emp = new Emp();
//        getAttribute获得的参数值是表单中name的值,name的值也要和数据库sql语句中相对应
        emp.setName(req.getParameter("name"));
        emp.setAge(Integer.parseInt(req.getParameter("age")));
        emp.setSex(req.getParameter("sex"));
        emp.setSalary(new BigDecimal(req.getParameter("salary")));
        emp.setDeptId(Integer.parseInt(req.getParameter("deptId")));


        //2.传到数据库
        empService.addEmp(emp);
        //3.重定向到jsp上
        //不能用
//        req.getRequestDispatcher("empList").forward(req,resp);
        resp.sendRedirect("empList");

    }
}
