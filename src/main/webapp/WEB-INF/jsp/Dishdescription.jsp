<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container" style="text-align: left">
    <div class="row">

        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide card-img-top" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="${dish.images[0].url}" alt="${dish.name}">
                    </div>
                    <c:forEach items="${dish.images}" begin="1" var="img">
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${img.url}" alt="${dish.name}">
                    </div>
                    </c:forEach>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <h4>${dish.name}</h4>
            <p class="text-muted">${dish.weight} grams</p>
            <p class="text-muted">${dish.calories} calories</p>
            <p class="text-muted">Preparing time: ${dish.preparingtime} min</p>
            <!-- <p class="text-muted">Components: cauliflower, cheese, seeds, sauce</p> -->
            <p class="card-text">${dish.description}</p>
            <div class="">
                <h5 class="card-title">${dish.price}$ <a href="/addToOrder/${dish.id}" class="btn btn-primary">Add to
                    order</a></h5>
            </div>
            <c:if test="${orderMap.containsKey(dish)}">
                <span class="text-muted">Already in order (${orderMap.get(dish)})</span>
            </c:if>
        </div>
        <c:if test="${not empty populars}">
            <h3>Customers who ordered this dish also ordered:</h3>

            <div class="container-fluid tab-pane" style="padding-bottom: 50px">
                <div class="d-flex flex-row flex-nowrap">
                    <c:forEach items="${populars}" var="popItem">
                        <div class="card card-block">
                            <a href="/dish/${popItem.id}"> <img class="card-img-top" src="${popItem.images[0].url}"
                                                                           alt="${popItem.name}"></a>
                            <h5>${popItem.name}</h5>
                            <p class="text-muted">${popItem.price}$</p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
                <div class="col-sm-10 col-sm-offset-1" >
                    <div class="page-header">
                        <h3 class="reviews">Leave your Review</h3>
                    </div>
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active text-uppercase reviews" id="comments-tab" data-toggle="tab" href="#comments" role="tab" aria-controls="comments" aria-selected="true">Reviews</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-uppercase reviews" id="addcomment-tab" data-toggle="tab" href="#addcomment" role="tab" aria-controls="addcomment" aria-selected="false">Add Review</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="comments" role="tabpanel" aria-labelledby="comments-tab">
                               <c:if test="${newCommentAdded}">
                                   <div class="card">
                                       <div class="card-header text-uppercase reviews">
                                               Your review will be added after moderation.
                                       </div>
                                   </div>
                               </c:if>
                                <c:if test="${empty reviews}">
                                    <div class="card">
                                        <div class="card-header text-uppercase reviews">
                                            There is no reviews yet
                                        </div>
                                    </div>
                                </c:if>

                                <c:forEach items="${reviews}" var="review">
                                <div class="card">
                                    <div class="card-header text-uppercase reviews">
                                        ${review.user.name}
                                    </div>
                                    <div class="card-block">
                                        <p class="card-text">${review.commentText}</p>
                                        <p class="card-text"><small class="text-muted">${review.date}</small></p>
                                    </div>
                                </div>
                                </c:forEach>
                            </div>
                            <div class="tab-pane fade" id="addcomment" role="tabpanel" aria-labelledby="addcomment-tab">
                                <form action="/dish/${dish.id}/addReview" method="get" class="form-horizontal" id="commentForm" role="form">
                                    <div class="form-group">
                                        <label for="commentArea" class="col-sm-2 control-label">Review</label>
                                        <div class="col-sm-10">
                                            <c:choose>
                                                <c:when test="${canComment}">
                                                    <textarea class="form-control" name="review" id="commentArea" rows="5" maxlength="1000"></textarea>
                                                </c:when>
                                                <c:otherwise>
                                                    <textarea class="form-control" placeholder="You have to sign in to add reviews" disabled name="review" id="commentArea" rows="5" maxlength="1000"></textarea>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <c:choose>
                                                <c:when test="${canComment}">
                                                    <button class="btn btn-success btn-circle text-uppercase" type="submit" id="submitComment"><span class="glyphicon glyphicon-send"></span> Submit Review</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button class="btn btn-success btn-circle text-uppercase disabled" type="submit" id="submitComment"><span class="glyphicon glyphicon-send"></span> Submit Review</button>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
    </div>
</div>

<style type="text/css">
    .card-block{
        margin-top: 5px;
        margin-left: 18px;
        margin-bottom: 5px;
    }

    .tab-content {
        padding: 50px 15px;
        border: 1px solid #ddd;
        border-top: 0;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
    }

</style>
<%@ include file="footer.jsp" %>