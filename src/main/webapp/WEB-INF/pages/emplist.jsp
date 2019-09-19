<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
</head>
<body>
<%--getAttribute传过来的是对象，要强转称泛型--%>
<%--<%List<Emp> empList = (List<Emp>) request.getAttribute("empList");%>--%>

<div class="container">
    <%--<div class="row">--%>
        <div class="<col>">
            <table class="table table-striped table-dark">
                <thead>
                <tr>

                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">性别</th>
                    <th scope="col">工资</th>
                    <th scope="col">部门</th>
                </tr>
                </thead>
                <tbody>
                <%--遍历emp数据--%>
                <c:forEach items="${empList}" var="emp">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.sex}</td>
                    <td>${emp.age}</td>
                    <td>${emp.salary}</td>
                    <%--部门要显示成名字--%>
                    <td>${emp.dept.dname}</td>
                    </c:forEach>
                </tr>

                </tbody>
            </table>
        <%--</div>--%>
            <a class="btn btn-secondary" href="/addempview" role="button">添加员工</a>

        </div>
</div>

<script src="/bootstrap4/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.4.1.min.js"></script>
</body>
</html>
