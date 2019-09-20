<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        // 此处function前省去了document，因为document代表着根节点
        // 这个function会在页面直面加载后执行
        $(function () {
            //绑定删除按钮的点击事件
            $(".delete").click(function () {
                //1.获取要删除的id
               var  id = $(this).data('id');
                //2.发送网络请求将id传入到servlet
                location.href = 'deleteemp?id=' + id;
            });
            //绑定修改按钮的点击事件
            $(".update").click(function () {
                var id = $(this).data('id');

                location.href = 'updateempview?id=' + id;
                });
        });

    </script>
</head>
<body>
<%--getAttribute传过来的是对象，要强转称泛型--%>
<%--<%List<Emp> empList = (List<Emp>) request.getAttribute("empList");%>--%>

<div class="container">
    <div class="<col>">
        <table class="table table-striped table-dark">
            <thead>
            <tr>
                <th scope="col">姓名</th>
                <th scope="col">年龄</th>
                <th scope="col">性别</th>
                <th scope="col">工资</th>
                <th scope="col">部门</th>
                <th scope="col">操作</th>
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
                <td>
                    <button type="button" class="btn btn-info btn-sm update" data-id=${emp.empId}>修改</button>
                    <button type="button" class="btn btn-warning btn-sm delete " data-id=${emp.empId}>删除</button>
                </td>
                </c:forEach>

            </tr>

            </tbody>
        </table>
        <a class="btn btn-primary" href="/addempview" role="button">添加员工</a>

    </div>
</div>

<script src="/bootstrap4/js/bootstrap.min.js"></script>

</body>
</html>
