<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <jsp:useBean id="now" scope="page" class="java.util.Date"/>
    ${now}
  </body>
</html>