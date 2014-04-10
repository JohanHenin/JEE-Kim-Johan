<%@page pageEncoding="UTF-8" contentType="text/html" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <form action="CheckAdhesionServlet" method="post" accept-charset="utf-8">
		Login : <input type="text" name="login" /> 
		E-mail : <input type="text" name="email" /> 
		J'ai lu et approuvé les conditions générales de ce site <input type="checkbox" name="approuve">
		<input type="submit" />
	</form>
  </body>
</html>