
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="languages.text" var="bundle"/>
<html>
<head>
    <title>Identification</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<div class="container">
    <h2 class="title"><fmt:message key="login.label.title" bundle="${bundle}"/></h2>
    <form action="identification" method="post" class="form">
        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="motPasse"><fmt:message key="login.label.mdp" bundle="${bundle}" /></label>
            <input type="password" id="motPasse" name="motPasse" class="form-control" required>
        </div>
        <input type="submit" value="<fmt:message key="login.button.submit" bundle="${bundle}"/> " class="btn btn-primary">
    </form>
    <c:if test="${message != null}">
        <hr>
        <h3 class="message"><c:out value="${message}" /></h3>
    </c:if>


    <form method="post" action="LanguageServlet">
        <select name="lang">
            <option value="fr">Français</option>
            <option value="en">English</option>
        </select>
        <input type="submit" value="<fmt:message key="login.label.language" bundle="${bundle}"/>"/>
    </form>
</div>
</body>
</html>

