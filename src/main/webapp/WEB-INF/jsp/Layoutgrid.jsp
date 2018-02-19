<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">

    <div class="col1" style="text-align: right; padding-top: 10px;">
        <div class="btn-group">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                Sort by
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/menu/${category}/sort/byPrice">Price</a>
                <a class="dropdown-item" href="/menu/${category}/sort/ByCalories">Calories</a>
                <a class="dropdown-item" href="/menu/${category}/sort/ByPreparingtime">Preparing time</a>
            </div>
        </div>
    </div>

    <div class="row1">

        <c:forEach items="${menuItems}" step="4" varStatus="loop">
            <div class="card-deck">
                <c:forEach items="${menuItems}" begin="${loop.index}" end="${loop.index+3}" var="item">
                    <div class="card">

                        <a href="/dish/${item.id}"> <img class="card-img-top" src="${item.picture}"
                                                                    alt="${item.name}"></a>

                        <c:if test="${orderMap.containsKey(item)}">
                            <div class="card-header">
                                In order (${orderMap.get(item)})
                            </div>
                        </c:if>
                        <div class="card-body">
                            <h4 class="card-title">${item.name}</h4>
                            <p class="card-text">${item.description}</p>
                        </div>

                        <div class="card-footer">
                            <h5 class="card-title inline">${item.price}$</h5>
                            <a href="/addToOrder/${item.id}" class="btn btn-primary inline">Add to cart</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>
<%@ include file="footer.jsp" %>