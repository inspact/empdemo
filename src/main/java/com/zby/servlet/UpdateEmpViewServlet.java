package com.zby.servlet;

import com.zby.entity.Dept;
import com.zby.entity.Emp;
import com.zby.service.DeptService;
import com.zby.service.EmpService;
import com.zby.service.impl.DeptServiceImpl;
import com.zby.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/updateempview")
public class UpdateEmpViewServlet extends HttpServlet {
   private EmpService empService = new EmpServiceImpl();
   private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        Integer empId = Integer.parseInt(req.getParameter("id"));
        //2.(回显)根据id查询数据,emp的数据是通过id查询的一条数据，所以返回值emp，而dept是遍历查询，数组接收
        Emp emp = empService.getEmpById(empId);
        List<Dept> deptList = deptService.listDept();
        //3.绑定数据到req，因为部门在另外一张表，所以需要绑定两个
        req.setAttribute("emp",emp);
        req.setAttribute("deptList",deptList);

        //4.转发到修改页上
        req.getRequestDispatcher("\\WEB-INF\\pages\\updateemp.jsp").forward(req,resp);

    }
}
