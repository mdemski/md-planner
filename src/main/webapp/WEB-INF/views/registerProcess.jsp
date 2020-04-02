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
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Konto założone poprawnie. Sprawdź skrzynkę pocztową aby dokończyć rejestrację.</h1>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>
