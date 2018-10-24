<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/register">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName"><br><br>
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName"><br><br>
            <button type="submit">Save</button>
        </form>
    </div>
</body>
</html>
