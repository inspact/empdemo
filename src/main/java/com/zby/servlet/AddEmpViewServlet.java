package com.zby.servlet;

import com.zby.entity.Dept;
import com.zby.service.DeptService;
import com.zby.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addempview")
public class AddEmpViewServlet extends HttpServlet {

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        查询数据库部门表的数据
        List<Dept> deptList = deptService.listDept();

        //req得到部门信息,数据绑定到req上
        req.setAttribute("deptList",deptList);


        req.getRequestDispatcher("\\WEB-INF\\pages\\addemp.jsp").forward(req,resp);
    }
}
