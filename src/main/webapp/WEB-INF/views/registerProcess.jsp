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
                <c:choose>
                    <c:when test="${successMessage != null}">
                        <h1>${successMessage}</h1> </br>
                        <a href="${mainUrl}/logowanie">Zaloguj</a>
                    </c:when>
                    <c:otherwise>
                        <h1>${errorMessage}</h1>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>
