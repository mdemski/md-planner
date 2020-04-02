<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: MarDem
  Date: 2019-09-01
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="mainUrl" value="/"/>
<main>
    <div>
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <!-- Card -->
                    <div class="card">

                        <!-- Card image -->
                        <img class="card-img-top"
                             src="${mainUrl}resources/static/antique-backdrop-background-164005.jpg"
                             alt="Card image cap">

                        <!-- Card content -->
                        <div class="card-body">


                            <c:choose>
                                <c:when test="${successMessage != null}">
                                    <h3>${successMessage}</h3>
                                </c:when>
                            </c:choose>
                            <form:form class="text-center border border-light p-5" method="post"
                                       modelAttribute="loginData">
                                <p class="h4 mb-4">Zaloguj</p>

                                <!-- Email -->
                                <form:input path="email" id="defaultLoginFormEmail" class="form-control mb-4"
                                            placeholder="E-mail"/>
                                <form:errors path="email"/>

                                <!-- Password -->
                                <form:password path="password" id="defaultLoginFormPassword" class="form-control mb-4"
                                               placeholder="Hasło"/>
                                <form:errors path="password"/>

                                <!-- Login button -->
                                <button class="btn btn-info btn-block my-4" type="submit">Zaloguj</button>

                                <!-- Reset button -->
                                <button class="btn btn-info btn-block my-4" type="reset">Wyczyść dane</button>

                                <a type="button" class="light-blue-text mx-2"
                                   href="https://pl-pl.facebook.com/oknadachowe">
                                    <i class="fab fa-facebook-f"></i>
                                </a>
                                <a type="button" class="light-blue-text mx-2"
                                   href="https://www.instagram.com/okna_okpol/">
                                    <i class="fab fa-instagram"></i>
                                </a>
                                <a type="button" class="light-blue-text mx-2" href="https://www.okpol.pl/">
                                    <i class="fab fa-github"></i>
                                </a>
                            </form:form>
                        </div>
                    </div>
                    <!-- Card -->
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>
