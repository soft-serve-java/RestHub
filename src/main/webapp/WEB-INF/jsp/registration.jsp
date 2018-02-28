<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    ${alreadyRegisteredMessage}
    ${IncorrectPassword}
    ${IncorrectName}
    <div class="row">
        <div class="col-md-4 col-md-offset-7" style="background: white">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="panel-heading"> <strong class="">Register</strong></div>
                        <form:form method="POST" class="form-horizontal" action="/registration" modelAttribute="registration">
        <div class="form-group">
            <div class="col-sm-9">
                <label for="inputEmail3" class="col-sm-3 control-label">Email</label>
                <form:input type="email" class="form-control" id="inputEmail3"
                       placeholder="Email"  path="email"  required=""/>
                <form:errors path="email" class="control-label"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9">
                <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                <form:input type="password" class="form-control" id="inputPassword3" path="password" placeholder="Password" name="password" required=""/>
                <form:errors path="password" class="control-label"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9">
                <label for="inputName3" class="col-sm-3 control-label">Name</label>
                <form:input type="text" class="form-control" id="inputName3" path="name" placeholder="Name" name="password" required=""/>
                <form:errors path="name" class="control-label"/>
            </div>
        </div>
        <div class="form-group last">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-success">Register</button>
            </div>
        </div>
    </form:form>
    </div>
                </div>
            </div>
        </div>
    </div>
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

