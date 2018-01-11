<%--
  Created by IntelliJ IDEA.
  User: nguoitoanco
  Date: 1/4/2018
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Welcome to Home Page</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/loginPage">Login</a></li>
    <li><a href="${pageContext.request.contextPath}/downloadPage">Download CV Template</a></li>
    <li><a href="${pageContext.request.contextPath}/uploadPage">Upload CV</a></li>
</ul>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>