<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Admin.jsp" %>
<div class="container">
    <%--@elvariable id="user" type="com.kh013j.model.domain.User"--%>
    <form:form method="POST" action="/admin/user/save" modelAttribute="user">
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
                    <input disabled type="password" class="form-control" id="inputPassword4" placeholder="Password"/>
                </c:if>
            </div>
        </div>
        <div class="form-row">
<%--            <div class="form-group col-md-6">
                <label for="inputLogin">Login</label>
                <form:input path="login" type="text" class="form-control" id="inputLogin"/>
            </div>--%>
            <div class="form-group col-md-4">
                <label for="inputState">Role</label>
                <form:select path="role" multiple="false" id="inputState" class="form-control">
                    <form:options items="${Roles}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Apply</button>
    </form:form>
</div>
<%@ include file="footer.jsp" %>
