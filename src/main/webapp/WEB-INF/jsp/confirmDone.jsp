<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>registration</title>
</head>

<body>
<div id="box">
    <div class="container py-2">
        <form:form method="POST" action="/confirmDone">
            <table class="table table-hover">
                <tbody>
                <h4>Congratulation!</h4>
                <h4>Your account activated, you can Login using your email and password!</h4>
                <a href="/login"><h4>Login</h4></a>
            </table>
        </form:form>
    </div>
</div>

<style>

    #box {
        width: 300px;
        padding: 20px;
        margin: 100px auto;
        background: #fff;
        -webkit-border-radius: 2px;
        -moz-border-radius: 2px;
        border: 1px solid #000;
    }
</style>

</body>
</html>