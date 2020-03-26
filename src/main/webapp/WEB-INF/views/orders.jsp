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
            <div class="col-sm">
                <!-- Search form -->
                <form:form class="md-form" method="POST">
                    <div class="md-form mt-0">
                        <input class="form-control" type="text" placeholder="Nr zlecenia" aria-label="Search">
                    </div>
                    <button class="btn btn-info btn-block my-4" value="submit">Szukaj</button>
                </form:form>
            </div>
            <div class="col-sm">
                <form:form class="md-form" method="POST" enctype="multipart/form-data">
                    <div class="custom-file">
                        <input type="file" name="file" class="custom-file-input" id="customFileLang" lang="pl-Pl" accept=".csv">
                        <label class="custom-file-label" for="customFileLang">Wybierz pliki</label>
                        <button class="btn btn-info btn-block my-4" value="submit">Wczytaj</button>
                    </div>
                </form:form>
            </div>
            <div class="col-sm">
                One of three columns
            </div>
        </div>
    </div>

    <div class="container">
        <!-- todo: tabela ze zleceniami -->
    </div>
</main>

<jsp:include page="footer.jsp"/>
