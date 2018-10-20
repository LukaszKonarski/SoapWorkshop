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
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=latin,latin-ext'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
    <%--&lt;%&ndash;<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>&ndash;%&gt;--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
</head>
<body>

<div class="container-fluid row">
    <div class="col-sm-10 col-md-11"></div>
    <div class="col-sm-2 col-md-1">
        <a href="<c:url value="/store/shoppingCart"/>" class="btn btn-default btn-sm" role="button">
            <span class="glyphicon glyphicon-shopping-cart"></span> KOSZYK
        </a>
    </div>
</div>


<div class="container container-table">
    <div class="row vertical-center-row">
        <div class="title text-center col-md-4 col-md-offset-4" href="/">SOAP WORKSHOP</div>
    </div>
</div>

<nav class="navbar navbar-light bg-white nav-bar-top-border nav-bar-bottom-border">
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
            <li class="active"><a href="#">O NAS</a></li>
            <li class="active"><a href="#">KONTAKT</a></li>
        </ul>
    </div>
</nav>


<div >
    <img src="../../../img/indexpic.jpg" class="mainPic container-fluid px-0">
</div>


<div class="container container-table">
    <div class="row title text-center vertical-center-row text-lowercase">
        ${currentCategory.name}
    </div>
</div>

<%--<div class="container">--%>
    <%--<div class="row">--%>
        <%--<header class="page-header">--%>
            <%--<div class="row">--%>
                <%--<div class="col-xs-12 title text-lowercase" >--%>
                    <%--${currentCategory.name}--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</header>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<div class="container">--%>
    <%--<table class="table">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Nazwa</th>--%>
            <%--<th>Cena</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach items="${products}" var="p">--%>
            <%--<tr>--%>
                <%--<td><a href="<c:url value="/store/productDetails/${p.id}"/>">${p.name}</a></td>--%>
                <%--<td>${p.price}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
<%--</div>--%>
<div class="row">
    <c:forEach items="${products}" var="p">
    <div class="col-md-4 col-sm-6 col-xs-12">
        <figure>
            <div class="img img-opacity">
                <%--<a href="http://soapworkshop.pl/kategoria/mydla/roza-2" class=" crop-photo" title="mydło róża">--%>
                    <%--<img src="https://cdn.shoplo.com/2772/products/th480/aaav/302-hr_soapworkshop341924.jpg" alt="hr_SoapWorkshop341924" />--%>
                <%--</a>--%>
            </div>
            <figcaption class="align-center">
                <h3 class="list-product-title">
                    <a href="<c:url value="/store/productDetails/${p.id}"/>">${p.name}</a>
                </h3>
                <div  class="product-price">
                    <p>${p.price}</p>
                </div>
            </figcaption>
        </figure>
    </div>
    </c:forEach>
</div>

</body>
</html>
