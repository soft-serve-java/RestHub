<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container py-2" style="width: 50rem">
    <form:form method="POST" action="/admin/dish/save" modelAttribute="dish" enctype="multipart/form-data">
        <table class="table table-hover">
            <tbody>
            <h4 >Dish</h4>
            <div class="form-row">
                <form:input path="id" type="hidden"/>
                <label>Name: </label>
                <form:input class="form-control" text="${dish.name}" path="name"/>
                <form:errors path="name" class="control-label"/>
            </div>
            <div class="form-row">
                <label>Description: </label>
                <form:textarea class="form-control" text="${dish.description}" path="description"/>
                <form:errors path="description" class="control-label"/>
            </div>

            <div class="form-row">
                <label>Category:</label>
                <form:select path="category" multiple="false" class="form-control">
                    <form:options items="${category}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>


            <div class="form-row">
                <label>Image: </label>
                <input class="form-control" type="file" id="image" name="pic" accept="image/*" multiple>
                <form:errors path="images" class="control-label"/>
                <c:if test="${dish != null}">
                      <div class="row justify-content-md-start">
                    <c:forEach items="${dish.images}" var="img">
                    <div class="col-md-2">
                              <img src="${img.url}" alt="image" width="100%"/>
                              <div class="row">
                                  <div class="col">
                                      <a href="/admin/dish/${dish.id}/removeImage/${img.id}">remove</a>
                                  </div>
                              </div>
                          </div>
                    </c:forEach>
                      </div>
                </c:if>
            </div>


            <div class="form-row">
                <label>Calories: </label>
                <form:input type="number" class="form-control" text="${dish.calories}" path="calories" />
                <form:errors path="calories" class="control-label"/>
            </div>

            <div class="form-row">
                <label>Weight: </label>
                <form:input type="number" class="form-control" text="${dish.calories}" path="weight" />
                <form:errors path="weight" class="control-label"/>
            </div>

            <div class="form-row">
                <label>Preparing time: </label>
                <form:input type="number" class="form-control" text="${dish.preparingtime}" path="preparingtime" />
                <form:errors path="preparingtime" class="control-label"/>
            </div>

            <div class="form-row">
                <label>Price: </label>
                <form:input type="number" class="form-control" text="${dish.price}" path="price" />
                <form:errors path="price" class="control-label"/>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </table>
    </form:form>
</div>
