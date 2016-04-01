<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. Reserve List</title>
</head>

<body>
    <H1>Listado de reservas</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Active</th>
				<th>User</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reserveList}" var="reserve">
				<tr>
					<td>${reserve.id}</td>
					<td>${reserve.court}</td>
					<td>${reserve.user}</td>
					<td>${reserve.date}</td>					
					<td><a href="<c:url value='/delete-reserve/${reserve.id}' />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/create-reserve'/>">Create reserve</a></p>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>