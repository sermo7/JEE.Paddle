<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Spring 4 MVC. Home</title>
</head>
<body>
	<H1>Página principal práctica Spring</H1>

	<p><a href="<c:url value='/court-list'/>">Pistas</a></p>
	<p><a href="<c:url value='/user-list'/>">Usuarios</a></p>
	<p><a href="<c:url value='/reserve-list'/>">Reservas</a></p>

	<p>UPM-MIW --- ${now}</p>
</body>
</html>