<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Авторизация</title>
    <style>
        .forma {
            padding-left: 40%;
            padding-right: 40%;
            padding-top: 40px;
        }
        .txt {
            text-align: center;
        }
        .btn-r{
            float: right;
            width: 120px;
        }
    </style>
</head>
<body>
<%--    форма авторизации      --%>
<form class="forma" method="post" action="auth">
    <div class="form-group">
        <h5 class="txt">Авторизация</h5>
        <label for="exampleInputEmail1">Логин</label>
        <input name="login" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
   </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Пароль</label>
        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary btn-r" value="Login">Вход</button>

</form>
</body>
</html>
