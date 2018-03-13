<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <%--@elvariable id="category" type="com.kh013j.model.domain.Category"--%>
    <form:form method="POST" action="/admin/category/save" modelAttribute="category">
        <div class="form-row align-items-center">
            <form:hidden path="id"/>
            <div class="form-group col-md-6">
                <label for="inputName">Name</label>
                <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Name"/>
            </div>

            <div class="col-md-2 align-self-center">
                <button type="submit" class="btn btn-primary">Apply</button>
            </div>
        </div>
    </form:form>
</div>
