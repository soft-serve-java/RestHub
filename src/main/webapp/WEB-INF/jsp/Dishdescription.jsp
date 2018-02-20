<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container" style="text-align: left">
    <div class="row">

        <div class="col">
            <img class="card-img-top" src="${dish.picture}">
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
                            <a href="/dish/${popItem.id}"> <img class="card-img-top" src="${popItem.picture}"
                                                                           alt="${popItem.name}"></a>
                            <h5>${popItem.name}</h5>
                            <p class="text-muted">${popItem.price}$</p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </div>
</div>

<style>
    .card-block {
        min-height: 250px;
        min-width: 300px;
        margin-right: 5px;
        text-align: center;
    }
</style>
<%@ include file="footer.jsp" %>