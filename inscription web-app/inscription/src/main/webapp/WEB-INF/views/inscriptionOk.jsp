<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adhésion en ligne</title>
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="alert alert-success">
		Bienvenue <c:out value="${inscription.login}"/>, votre inscription a bien été prise en compte 
		le <fmt:formatDate pattern="dd MMMMM yyyy 'à' HH:mm:ss" value="${inscription.creation}"/>.
	</div>
</div>
</body>
</html>
