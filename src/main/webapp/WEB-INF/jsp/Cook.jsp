<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <table class="table">
        <thead>
        <tr style="text-align: center;">
            <th>Name</th>
            <th>Weight</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Dishes}" var="dish">
            <c:forEach begin = "1" end="${dish.quantity}">
            <tr>
                <td>${dish.dish.name}</td>
                <td>${dish.dish.weight}</td>
                <td>
                    <c:if test="${dish.status.name=='preparing'}">
                        <a href="/cook/gotit/${dish.id}" class="btn btn-warning" style="margin-bottom: 10%">
                            Got it!<span class="fa fa-check"></span></a>
                        </a>
                    </c:if>
                    <c:if test="${dish.status.name=='cooking'}">
                        <a href="/cook/done/${dish.id}" class="btn btn-success" style="margin-bottom: 10%">
                            Done<span class="fa fa-check"></span></a>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>