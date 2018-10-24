<%@include file="/WEB-INF/jspf/header.jspf"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">
    <form role="form" action="${pageContext.request.contextPath}/loginUrl" method="post" class="needs-validation" novalidate>

        <br><br><br>

        <div class="form-row-m">
            <label for="input_email">Email</label>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                </div>
                <input type="email" class="form-control" id="input_email"
                       pattern='^([A-Za-z0-9_\-.+])+@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,})$'
                       placeholder="Email" name="username" autocomplete="off" value="" required>
                <div class="invalid-feedback">
                    Enter email!
                </div>
            </div>
        </div>
        <div class="form-row-m">
            <label for="input_password">Password</label>
            <input type="password" class="form-control" id="input_password"
                   pattern='(.){4,20}'
                   placeholder="Password" name="password" autocomplete="off" value="">
            <div class="invalid-feedback">
                Must be from 4 to 20 characters!
            </div>
        </div>
        <br>
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <div>
            <button type="submit" class="btn btn-outline-success but_login_sign_in">Submit</button>
        </div>
    </form>
</div>
<script><%@include file="/WEB-INF/js/boot-html-valid.js"%></script>
</body>
</html>
