<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 2/24/18
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file = "Admin.jsp" %>
<div class="container">
    <c:forEach items="${reviews}" var="review">
        <div class="card">
            <div class="card-header text-uppercase reviews">
                    By: ${review.user.name}
            </div>
            <div class="card-block">
                <p class="card-text">${review.commentText}</p>
                <p class="card-text"><small class="text-muted">${review.date}</small></p>
                <p class="card-text"><small class="text-muted">Dish: ${review.dish.name}</small></p>
            </div>
                <c:choose>
                    <c:when test="${review.approved}">
                     <div class="card-footer text-right bg-success">
                        <a class="btn btn-success disabled" href="/">Approve</a>
                        <a class="btn btn-danger" href="/admin/reviews/${review.id}/tweak?approved=false">Reject</a>
                     </div>
                    </c:when>
                    <c:when test="${review.approved == null}">
                        <div class="card-footer text-right">
                            <a class="btn btn-success" href="/admin/reviews/${review.id}/tweak?approved=true">Approve</a>
                            <a class="btn btn-danger" href="/admin/reviews/${review.id}/tweak?approved=false">Reject</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="card-footer text-right bg-danger">
                            <a class="btn btn-success" href="/admin/reviews/${review.id}/tweak?approved=true">Approve</a>
                            <a class="btn btn-danger disabled" href="/">Reject</a>
                        </div>
                    </c:otherwise>
                </c:choose>
        </div>
    </c:forEach>
</div>
<%@ include file = "footer.jsp" %>
