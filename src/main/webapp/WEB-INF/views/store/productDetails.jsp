<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 08.07.2018
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Soap Workshop</title>
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


    <div class="container">
        <h2>${currentCategory.name}</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Nazwa</th>
                <th>Cena</th>
                <th>Opis</th>
                <th>Ilość</th>
                <th>Kup</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.stock}</td>
                <td><%--@elvariable id="product" type=""--%>
                    <form:form method="post" modelAttribute="product">
                        <input type="hidden" name="id" value="${product.id}"/>
                        <input type="hidden" name="name" value="${product.name}"/>
                        <input type="hidden" name="price" value="${product.price}"/>
                        <input type="hidden" name="subtotal" value="0"/>
                        <input type="number" name="quantity" value="1" max="${product.stock}" min="1" step="1"/>
                        <input type="submit" value="Dodaj do koszyka">
                    </form:form></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
