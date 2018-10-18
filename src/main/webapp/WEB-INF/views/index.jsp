<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 07.07.2018
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Soap Workshop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="bg">

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

    <div>
        <img src="../img/indexpic.jpg" class="mainPic container-fluid px-0">
    </div>


</div>

</body>
</html>
