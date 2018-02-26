<%@ include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>registration</title>
</head>

<body>

<div id="login-box">
${alreadyRegisteredMessage}
<div class="container py-2">
    <form:form method="POST" action="/registration" modelAttribute="registration">
        <table class="table table-hover">
            <tbody>
            <h3>RestHub new User</h3>

            <p>
                <label>Enter email</label>
                <form:input path="email" type="email" class="form-control" placeholder="email" value="${registration.email}"/>
                <form:errors path="email" class="control-label"/>
            </p>

            <p>
                <label>Enter password</label>
                <form:input path="password" type="password" class="form-control" placeholder="password"/>
                <form:errors path="password" class="control-label"/>
            </p>


            <p>
                <label>Enter name</label>
                <form:input path="name" type="name" class="form-control" placeholder="name" value="${registration.name}"/>
                <form:errors path="name" class="control-label"/>
            </p>

            <button type="submit" class="btn btn-primary">Save</button>

        </table>
    </form:form>
</div>
</div>

<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border-color: #ebccd1;
    }

    .msg {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #31708f;
        background-color: #d9edf7;
        border-color: #bce8f1;
    }

    #login-box {
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
