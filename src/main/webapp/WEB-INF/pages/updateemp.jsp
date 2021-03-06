<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateemp</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <%--表单中的数据都需要事先从数据库中查询拿过来，对应的servlet中应事先绑定到req，此处可以直接调用--%>
            <form action="updateemp" method="post">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" placeholder="姓名" name="name" value="${emp.name}">
                </div>

                <div class="form-check">

                    <input class="form-check-input" type="radio" name="sex" id="sex1" value="男" <c:if test="${emp.sex=='男'}">checked</c:if>>
                    <label class="form-check-label" for="sex1">
                        男
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sex" id="sex2" value="女" <c:if test="${emp.sex=='女'}">checked</c:if>>
                    <label class="form-check-label" for="sex2">
                        女
                    </label>
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="number" class="form-control" id="age" placeholder="年龄" name="age" value="${emp.age}">
                </div>
                <div class="form-group">
                    <label for="salary">工资</label>
                    <input type="number" class="form-control" id="salary" placeholder="工资" name="salary" value="${emp.salary}">
                </div>
                <br>
                <%--部门显示成下拉条，用部门id去传，但是显示的时候要显示部门名字,这些要在增加页面初始时出现，在addempview里加--%>
                <div class="form-group">
                    <label for="dept">部门</label>
                    <select class="custom-select" id="dept" name="deptId">
                        <%--dept的数据需要另外查询，在servlet中增加查询dept的方法，在此处调用--%>
                        <c:forEach items="${deptList}" var="dept">
                            <c:if test="${dept.deptId != emp.deptId}" >
                                <option value="${dept.deptId}">${dept.dname}</option>
                            </c:if>
                            <c:if test="${dept.deptId == emp.deptId}" >
                                <option value="${dept.deptId}" selected>${dept.dname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <%--因为要根据员工ID修改，所以获取员工ID值，在对应的servlet中调用修改方法修改--%>
                <input type="hidden" name="empId" value="${emp.empId}">
                <br>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


<script src="/bootstrap4/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.4.1.min.js"></script>
</body>
</html>
