<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<table>
	     <c:forEach var='parameter' items='${paramValues}'>   
         <ul>  
            <%-- Show the key, which is the request parameter  
                 name --%>  
            <li><b><c:out value='${parameter.key}'/></b>:</li>  
   
            <%-- Iterate over the values -- a String[] --   
                 associated with this request parameter --%>  
            <c:forEach var='value' items='${parameter.value}'>  
               <%-- Show the String value --%>  
               <c:out value='${value}'/>     
            </c:forEach>  
         </ul>  
      </c:forEach>  
	</table>
	${param["language"]}
	<%out.print(request.getParameterValues("version")); %>
</body>
</html>