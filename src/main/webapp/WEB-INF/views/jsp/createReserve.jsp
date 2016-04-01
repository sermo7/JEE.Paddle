<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateReserve</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear una reserva</h1>
	<form:form action="create-reserve" modelAttribute="reserve">
		<p>Court:
			<form:input path="court" placeholder="court" />
		</p>
		<p>User:
			<form:input path="user" placeholder="user" />
		</p>
		<p>Date:
			<form:input path="date" placeholder="date" />
		</p>
		
		<p><input type="submit" value="Crear reserva"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>