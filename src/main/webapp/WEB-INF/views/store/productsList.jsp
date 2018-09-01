<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 08.07.2018
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td><a href="<c:url value="/store/productDetails/${p.id}"/>">${p.name}</a></td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
