<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 1/29/18
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "header.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th style="width: 40%">Title</th>
            <th style="width: 20%">Price</th>
            <th style="width: 15%">Quantity</th>
            <th style="width: 30%"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-4">
                        <img src="https://mafia.ua/storage/editor/fotos/450x450/filadelfiya-miks.jpeg" class="w-100">

                    </div>
                    <div class="col-md-6">
                        <h4 >Sushi Pliladeplia</h4>
                        <p class="text-muted">1000 grams</p>
                    </div>
                </div>
            </td>
            <td>30.32$</td>
            <td >
                <div class="row">
                    <div class="input-group">
                        <button type="button" class="btn btn-secondary" disabled="disabled" data-type="minus" data-field="quant[1]">
                            <span class="fa fa-minus"></span>
                        </button>
                        <input type="text" name="quant[1]" class="form-control input-number" value="1" min="1" max="10">
                        <button type="button" class="btn btn-secondary" data-type="plus" data-field="quant[1]">
                            <span class="fa fa-plus"></span>
                        </button>
                    </div>
                </div></td>
            <td style="text-align: center">
                <button class="btn btn-danger">
                    <span class="fa fa-times"></span>
                </button>
            </td>
        </tr>
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-4">
                        <img src="https://mafia.ua/storage/editor/fotos/450x450/fresh-miks-metrovaya.jpeg" class="w-100">

                    </div>
                    <div class="col-md-6">
                        <h4 >Pizza Fresh Mix</h4>
                        <p class="text-muted">1200 grams</p>
                    </div>
                </div>
            </td>
            <td>18.99$</td>
            <td >
                <div class="row">
                    <div class="input-group">
                        <button type="button" class="btn btn-secondary" disabled="disabled" data-type="minus" data-field="quant[1]">
                            <span class="fa fa-minus"></span>
                        </button>
                        <input type="text" name="quant[1]" class="form-control input-number" value="1" min="1" max="10">
                        <button type="button" class="btn btn-secondary" data-type="plus" data-field="quant[1]">
                            <span class="fa fa-plus"></span>
                        </button>
                    </div>
                </div></td>
            <td style="text-align: center">
                <button class="btn btn-danger">
                    <span class="fa fa-times"></span>
                </button>
            </td>
        </tr>
        <tr>
            <td>
                <div class="row">
                    <div class="col-md-4">
                        <img src="https://mafia.ua/storage/editor/fotos/450x450/bastardo-staryj-krym-inkerman-ukraina.png" class="w-100">

                    </div>
                    <div class="col-md-6">
                        <h4 >Wine Inkerman Old Crimea</h4>
                        <p class="text-muted">0.75 l</p>
                    </div>
                </div>
            </td>
            <td>12.85$</td>
            <td >
                <div class="row">
                    <div class="input-group">
                        <button type="button" class="btn btn-secondary" disabled="disabled" data-type="minus" data-field="quant[1]">
                            <span class="fa fa-minus"></span>
                        </button>
                        <input type="text" name="quant[1]" class="form-control input-number" value="1" min="1" max="10">
                        <button type="button" class="btn btn-secondary" data-type="plus" data-field="quant[1]">
                            <span class="fa fa-plus"></span>
                        </button>
                    </div>
                </div></td>
            <td style="text-align: center">
                <button class="btn btn-danger">
                    <span class="fa fa-times"></span>
                </button>
            </td>
        </tr>
        </tbody>
    </table>

    <hr/>
    <div class="row">
        <h5 class="col-md-4">
            You have 3 items in your cart
        </h5>
        <h4 class="col-md-5">
            Total amount: 61.55$
        </h4>
        <button class="btn btn-success col-md-2">
            Submit
        </button>
    </div>
</div>
<%@ include file = "footer.jsp" %>