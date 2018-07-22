<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 16.07.2018
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Your shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container-fluid">
    <h1>SOAP WORKSHOP</h1>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">HOME</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">SKLEP<span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${categories}" var="c">
                            <li><a href="<c:url value="/store/productsList/${c.id}"/>">${c.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#">O NAS</a></li>
                <li><a href="#">KONTAKT</a></li>
            </ul>
        </div>
    </nav>

    `
    <div class="container">
        <h2>Twój koszyk</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Nazwa</th>
                <th>Cena</th>
                <th>Ilość</th>
                <th>Razem</th>
                <th>Zmień ilość</th>
                <th>Usuń</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>RAZEM:</th>
                <th>${cartTotal}</th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${cart}" var="cartItem">
                <tr>
                    <td>${cartItem.name}</td>
                    <td>${cartItem.price}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.subtotal}</td>
                    <td>
                            <%--@elvariable id="product" type=""--%>
                        <form:form method="post" action="/store/shoppingCart" modelAttribute="product">
                            <input type="hidden" name="id" value="${cartItem.id}"/>
                            <input type="hidden" name="name" value="${cartItem.name}"/>
                            <input type="hidden" name="price" value="${cartItem.price}"/>
                            <input type="hidden" name="subtotal" value="${cartItem.subtotal}"/>
                            <input type="hidden" name="quantity" value="${cartItem.quantity}"/>
                            <input type="number" name="editedQuantity" value="1" max="${cartItem.stock}" min="1"
                                   step="1"/>
                            <input type="submit" class="btn btn-default" value="Edytuj">
                        </form:form>
                    </td>
                    <td>
                        <a href="<c:url value="/store/deleteItemFromCart/${cartItem.id}"/>" class="btn btn-default"
                           role="button">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
