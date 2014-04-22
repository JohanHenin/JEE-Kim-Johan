<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <form action="CheckAdhesionServlet" method="post" accept-charset="utf-8">
		Login : <input type="text" name="login" value="${not empty login ? login : ''}"/>
		E-mail : <input type="text" name="email" value="${not empty email ? email : ''}"/>
		J'ai lu et approuvé les conditions générales de ce site <input type="checkbox" name="approuve" ${not empty approuve ? 'checked' : ''}>
		<input type="submit" />
	</form>
    <c:if not empty wrongLogin>
        <p>
            ${wrongLogin}
        </p>
    </c:if>
    <c:if not empty wrongEmail>
        <p>
            ${wrongEmail}
        </p>
    </c:if>
    <c:if not empty wrongApprouve>
        <p>
            ${wrongApprouve}
        </p>
    </c:if>
  </body>
</html>