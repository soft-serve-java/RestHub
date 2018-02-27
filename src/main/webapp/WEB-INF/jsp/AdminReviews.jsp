<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 2/24/18
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col1" style="text-align: right; padding-top: 10px;">
        <div class="btn-group">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                Show
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/admin/reviews">All</a>
                <a class="dropdown-item" href="/admin/reviews?show=new">New</a>
                <a class="dropdown-item" href="/admin/reviews?show=approved">Approved <i class="fa fa-thumbs-up"></i></a>
                <a class="dropdown-item" href="/admin/reviews?show=rejected">Rejected <i class="fa fa-thumbs-down"></i></a>
            </div>
        </div>
    </div>

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
                        <a class="btn btn-success disabled" href="/">Approve <i class="fa fa-thumbs-up"></i></a>
                        <a class="btn btn-danger" href="/admin/reviews/${review.id}/tweak?approved=false">Reject <i class="fa fa-thumbs-down"></i></a>
                     </div>
                    </c:when>
                    <c:when test="${review.approved == null}">
                        <div class="card-footer text-right">
                            <a class="btn btn-success" href="/admin/reviews/${review.id}/tweak?approved=true">Approve <i class="fa fa-thumbs-up"></i></a>
                            <a class="btn btn-danger" href="/admin/reviews/${review.id}/tweak?approved=false">Reject <i class="fa fa-thumbs-down"></i></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="card-footer text-right bg-danger">
                            <a class="btn btn-success" href="/admin/reviews/${review.id}/tweak?approved=true">Approve <i class="fa fa-thumbs-up"></i></a>
                            <a class="btn btn-danger disabled" href="/">Reject <i class="fa fa-thumbs-down"></i></a>
                        </div>
                    </c:otherwise>
                </c:choose>
        </div>
    </c:forEach>
    <div class="menuPagination">
        <nav aria-label="RestHub menu pagination">
            <ul class="pagination">
                <c:choose>
                <c:when test="${page == 1}">
                <li class="page-item disabled">
                    </c:when>
                    <c:otherwise>
                <li class="page-item">
                    </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/reviews?show=${showBy}&page=${page-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${maxPages}" varStatus="loop">
                    <c:choose>
                        <c:when test="${page == loop.index}">
                            <li class="page-item active">
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                        </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/reviews?show=${showBy}&page=${loop.index}">${loop.index}</a>
                    </li>
                </c:forEach>
                <c:choose>
                <c:when test="${page == maxPages}">
                <li class="page-item disabled">
                    </c:when>
                    <c:otherwise>
                <li class="page-item">
                    </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/reviews?show=${showBy}&page=${page+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
