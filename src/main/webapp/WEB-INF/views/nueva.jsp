<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Nueva Pagina</title>
</head>
<body>
<h1>
	Nueva pagina!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> Your name is ${ nombre.name }</p>
<h2> Nueva pagina </h2>
<hr>
<% for(int i=1;i<=6;i++){%>
<h1>hola ${i}</h1>
<%}%>
<hr>
<c:forEach var="palabra" items="${lista}"
		   varStatus="status">
	<li>
		<c:out value="${palabra}" />
		<c:if test="${status.first}">(primer dato!)</c:if>
		<c:if test="${status.last}">(ultimo dato!)</c:if>
	</li>
</c:forEach>
</body>
</html>
