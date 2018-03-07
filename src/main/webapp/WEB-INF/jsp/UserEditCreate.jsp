<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <%--@elvariable id="user" type="com.kh013j.model.domain.User"--%>
    <form:form method="POST" action="/admin/user/save" modelAttribute="user" enctype="multipart/form-data">
        <div class="form-row">

            <div class="form-group col-md-6">
                <form:hidden path="id"/>
                <label for="inputEmail4">Email</label>
                <form:input path="email" type="email" class="form-control" id="inputEmail4" placeholder="Email"/>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Password</label>
                <c:if test="${null==user.email}">
                    <form:input path="password" type="password" class="form-control" id="inputPassword4"
                                placeholder="Password"/>
                </c:if>
                <c:if test="${null!=user.email}">
                    <form disabled type="password" class="form-control" id="inputPassword4" placeholder="Password"/>
                </c:if>
            </div>
            <label>Avatar: </label>
            <input class="form-control" type="file" name="pic" accept="image/*"/>
        </div>
        <div class="form-row">
<%--            <div class="form-group col-md-6">
                <label for="inputLogin">Login</label>
                <form:input path="login" type="text" class="form-control" id="inputLogin"/>
            </div>--%>
            <div class="form-group col-md-4">
                <label for="inputState">Roles</label>
                <form:select path="roles" multiple="true" id="inputState" class="form-control">
                    <form:options items="${Roles}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Apply</button>
    </form:form>
</div>