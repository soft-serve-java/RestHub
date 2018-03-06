<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <form id="selectTable" method="POST" action="/admin/setTableNumber">
                Current table number is ${tables.currentTable}
                 You can set table number here
                <select class="selectpicker" name="selectedNumber">
                    <c:forEach begin="1" end="${tables.quantityOfTables}"  varStatus="loop">
                        <option value="${loop.index}">
                                ${loop.index}
                        </option>
                    </c:forEach>
                </select>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-success col-md-2">OK</button>
    </form>
</div>