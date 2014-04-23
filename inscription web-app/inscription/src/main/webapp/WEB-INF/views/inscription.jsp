<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adhésion en ligne</title>
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h3>Saisissez vos informations</h3>
	<form class="col-md-4" action="<c:url value="/inscription" />" method="post" accept-charset="UTF-8">
		<c:set var="hasLoginError" value="${not empty errors['login']}"/>
		<div class="form-group ${hasLoginError ? 'has-error' : ''}">
			<label for="login">login</label>
			<input type="text" id="login" class="form-control" name="login" value="<c:out value="${param['login']}"/>">
			<c:if test="${hasLoginError}">
				<div class="label label-danger"><c:out value="${errors['login']}"/></div>
			</c:if>
		</div>
		<c:set var="hasEmailError" value="${not empty errors['email']}"/>
		<div class="form-group ${hasEmailError ? 'has-error' : ''}">
			<label for="email">e-mail</label>
			<input type="text" id="email" class="form-control" name="email" value="<c:out value="${param['email']}"/>">
			<c:if test="${hasEmailError}">
				<div class="label label-danger"><c:out value="${errors['email']}"/></div>
			</c:if>
		</div>
		<div class="form-group">
			<input type="checkbox" name="conditionsGeneralesApprouvees" ${param['conditionsGeneralesApprouvees'] ? 'checked' : ''} value="true">
			J'ai lu et approuvé les conditions générales du site
			<c:if test="${not empty errors['conditionsGeneralesApprouvees']}">
				<div class="label label-danger"><c:out value="${errors['conditionsGeneralesApprouvees']}"/></div>
			</c:if>
		</div>
		<button type="submit" class="btn btn-default">Adhérer</button>
	</form>
</div>
</body>
</html>
