<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>
<h1>Spring MVC multi files upload example</h1>

<form method="POST" action="${pageContext.request.contextPath}/uploadFiles" enctype="multipart/form-data">
    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/>
    <input type="submit" value="Submit" />
</form>

</body>
</html>