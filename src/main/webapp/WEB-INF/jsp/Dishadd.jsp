<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 1/29/18
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file = "header.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <table class="table table-hover">
        <tbody>
        <tr>
            <td>
                <h4 >Add new dish</h4>
                <div class="row">
                    <div class="col">
                        <row>
                            <p class="text-muted">Availability:
                                <input type="radio" name="avalible" value="yes"> yes
                                <input type="radio" name="avalible" value="no"> no<br>
                        </row>
                        <p class="text-muted">Name:</p>
                        <textarea name="comment" cols="105" rows="1">${dish.name}</textarea></p>

                        <row>
                            <p class="text-muted">Category:
                                <input type="radio" name="Category" value="Soups"> Soups
                                <input type="radio" name="Category" value="Meals"> Meals
                                <input type="radio" name="Category" value="Drinks"> Drinks
                                <input type="radio" name="Category" value="Deserts"> Deserts <br>
                        </row>

                        <p class="text-muted">Components:</p>
                        <textarea name="comment" cols="105" rows="1"></textarea></p>
                        <p class="text-muted">Description:</p>
                        <textarea name="comment" cols="105" rows="3">${dish.description}</textarea></p>
                        <p class="text-muted">Picture:</p>
                        <p><input type="file" name="f">
                        <p class="text-muted">Weight:</p>
                        <textarea name="comment" cols="20" rows="1">${dish.weight}</textarea></p>
                        <p class="text-muted">Calories:</p>
                        <textarea name="comment" cols="20" rows="1">${dish.calories}</textarea></p>
                        <p class="text-muted">Preparing time:</p>
                        <textarea name="comment" cols="20" rows="1">${dish.preparingtime} min</textarea></p>
                        <p class="text-muted">Price:</p>
                        <textarea name="comment" rows="1">${dish.price}$</textarea></p>

                        <a href="/admin/dishadd" class="btn btn-success">
                            Save <span class="fa fa-check"></span>
                        </a>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<%@ include file = "footer.jsp" %>