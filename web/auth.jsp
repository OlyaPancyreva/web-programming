<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .txt {
            padding: 40px;
            font-family: "Apple Color Emoji", serif;
        }

        .btn-t {
            margin-left: 200px;
        }
    </style>
</head>
<body>
<%
    String userName = null;
    String cookieName = request.getParameter("login");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName)) {
                userName = c.getValue();
            }
        }
    }
%>
<h1 class="txt">Привет, <%= userName%></h1>
<br>
<form action="hello" method="post">
    <button type="submit" value="Execute" class="btn btn-primary btn-t">Выход</button>
</form>
</body>
</html>
