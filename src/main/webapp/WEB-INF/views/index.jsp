<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: MarDem
  Date: 15.09.2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="mainUrl" value="/"/>
<main>
    <a href="${mainUrl}logowanie" class="blue-text">
        <h6 class="font-weight-bold mb-3"><i class="fas fa-fire pr-2"></i>Logowanie</h6>
    </a>
    <!-- Excerpt -->
    <p class="dark-grey-text">Zaloguj się do systemu aby móc składać zamówienia, przeglądać historię zamówień
        oraz sprawdzać poziom realizacji własnych zleceń</p>
</main>

<jsp:include page="footer.jsp"/>
