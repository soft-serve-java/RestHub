<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "Admin.jsp" %>

<div class="container py-2" style="width: 50rem">
    <form:form method="POST" action="/admin/dish/save" modelAttribute="dish">
        <table class="table table-hover">
            <tbody>
            <h4 >Edit dish</h4>
            <div class="form-row">
                <form:input path="id" type="hidden"/>
                <label>Name: </label>
                <form:textarea  class="form-control" cols="105" rows="1" text="${dish.name}" path="name" />
            </div>

<%--            <div class="form-row">
                <label>Avalibility: </label>
            </div>--%>

            <div class="form-row">
                <label>Description: </label>
                <form:textarea class="form-control" cols="105" rows="2" text="${dish.description}" path="description" />
            </div>

            <div class="form-row">
                <label>Category:</label>
                <form:select path="category" multiple="false" class="form-control">
                    <form:options items="${Category}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>

           <div class="form-row">
                <label>Picture: </label>

            </div>

            <div class="form-row">
                <label>Calories: </label>
                <form:textarea class="form-control" cols="20" rows="1" text="${dish.calories}" path="calories" />
            </div>

            <div class="form-row">
                <label>Preparing time: </label>
                <form:textarea class="form-control" cols="20" rows="1" text="${dish.preparingtime}" path="preparingtime" />
            </div>

            <div class="form-row">
                <label>Price: </label>
                <form:textarea class="form-control" cols="20" rows="1" text="${dish.price}" path="price" />
            </div>



            <button type="submit" class="btn btn-primary">Save</button>
        </table>
    </form:form>
</div>
<%@ include file = "footer.jsp" %>