<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <jsp:useBean id="now" scope="page" class="java.util.Date"/>

   	Bienvenue ${param.login}, votre inscription a bien été prise en compte
    le <fmt:formatDate value="${now}" pattern="dd MMM yyyy à HH:mm:ss" />
  </body>
</html>