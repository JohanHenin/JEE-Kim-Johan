<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<c:forEach var="name" items="${requestScope['ListName']}">
		<option value="${ListName.nom}">${ListName.nom}</option>
	</c:forEach>
	${param}
</body>
</html>