
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<body>
<form method="post" action="${pageContext.request.contextPath}/register">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName"><br><br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName"><br><br>
    <button type="submit">Save</button>
</form>
</body>
</body>
</html>
