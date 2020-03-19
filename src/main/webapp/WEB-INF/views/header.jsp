<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MarDem
  Date: 15.09.2019
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="mainUrl" value="/"/>
<html>
<head>
    <title>Konfigurator okienny</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="${mainUrl}resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="${mainUrl}resources/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="${mainUrl}resources/css/style.css" rel="stylesheet">
    <!-- Stepper CSS -->
    <link href="${mainUrl}resources/css/addons-pro/steppers.css" rel="stylesheet">
    <!-- Stepper CSS - minified-->
    <link href="${mainUrl}resources/css/addons-pro/steppers.min.css" rel="stylesheet">

</head>
<body>
<header>
    <!--Navbar -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-light rgba-grey-light">
        <a href='${mainUrl}' class="navbar-brand"><img
                src="https://www.okpol.pl/wp-content/uploads/2015/10/2015-logo-okpol-pl-217-50.png" alt="OKPOL"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4"
                aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light">1
                        <i class="fas fa-envelope"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href='${mainUrl}rejestracja'>Zarejestruj się</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href='${mainUrl}moje-konto'>Moje konto</a>
                </li>
            </ul>
        </div>
    </nav>
    <!--/.Navbar -->
</header>
