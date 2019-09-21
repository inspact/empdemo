<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <form action="login">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" id="username" placeholder="用户名" name="username">

                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="密码" name="password">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">登录</button>
            </form>
        </div>
    </div>
</div>


<script src="/bootstrap4/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.4.1.min.js"></script>
</body>
</html>

