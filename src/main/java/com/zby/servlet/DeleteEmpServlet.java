package com.zby.servlet;

import com.zby.service.EmpService;
import com.zby.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteemp")
public class DeleteEmpServlet extends HttpServlet {
        private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.servlet接收jsp , 得到要删除的id
        Integer empId = Integer.parseInt(req.getParameter("id")) ;

        //2.调用业务层删除数据
        empService.deleteEmpById(empId);

        //3.回到主页面
        resp.sendRedirect("empList");
    }
}
