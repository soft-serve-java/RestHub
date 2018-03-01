<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <%--@elvariable id="user" type="com.kh013j.model.domain.User"--%>
    <form:form method="POST" action="/admin/user/save" modelAttribute="user">
            <div class="form-group col-md-6">
                <form:hidden path="id"/>
                <label for="inputEmail4">Email</label>
                <form:input path="email" type="email" class="form-control" id="inputEmail4" placeholder="Email"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputName">Name</label>
                <form:input path="name" type="text" class="form-control" id="inputName"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputState">Roles</label>
                <form:select path="roles" multiple="true" id="inputState" class="form-control">
                    <form:options items="${Roles}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>

        <button type="submit" class="btn btn-primary">Apply</button>
    </form:form>
</div>