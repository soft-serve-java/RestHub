<%@ page isErrorPage="true" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>registration</title>
</head>

<body>
<div id="box">
    <div class="container py-2">
            <table class="table table-hover">
                <tbody>
                <h4>A confirmation link has been sent to your Email</h4>
                <a href="/registration"><h4>Change Email</h4></a>
            </table>
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