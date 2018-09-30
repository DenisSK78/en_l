
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<br><br>
<form action="${pageContext.request.contextPath}/loginUrl" method="post">
    <label for="username">Логин: </label><input type="text" name="username" id="username"/><br><br>
    <label for="password">Пароль: </label><input type="password" name="password" id="password"/><br><br>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <button type="submit">Войти</button>
</form>

</body>
</html>
