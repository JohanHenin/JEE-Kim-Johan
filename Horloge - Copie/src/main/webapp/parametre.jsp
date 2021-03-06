<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	margin-left: auto;
	margin-right: auto;
	max-width: 90%;
	border-collapse: collapse;
	border-spacing: 0px;
}

table td {
	padding: 0.1em 0.3em;
	border: thin solid #C8C8C8;
}
</style>
</head>
<body>
	<table>
		<c:forEach var="parameter" items="${paramValues}">
			<tr>
				<td><c:out value='${parameter.key}' />
				<td><c:forEach var='value' items='${parameter.value}'>
						<%-- Show the String value --%>
						<c:out value='${value}' />
					</c:forEach> <!--<c:out value="${element.value}"    default="inconnu" />--></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>