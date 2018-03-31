<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <form:form method="POST" action="/admin/status/save" modelAttribute="status">
        <table class="table table-hover">
            <tbody>

            <h4 >Status</h4>
                <form:input path="id" type="hidden"/>
                <form:textarea name="comment" path="name" cols="20" rows="1" text="${status.name}" class="form-control"/>
            <button type="submit" class="btn btn-primary">Save</button>
        </table>
    </form:form>
</div>