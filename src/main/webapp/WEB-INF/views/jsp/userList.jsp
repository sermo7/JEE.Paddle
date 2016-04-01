<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. User List</title>
</head>

<body>
    <H1>Listado de usuarios</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>UserName</th>
				<th>Mail</th>
				<th>Password</th>
				<th>Birthdate</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.mail}</td>
					<td>${user.password}</td>
					<td>${user.birthDate}</td>
					<td><a href="<c:url value='/delete-user/${user.id}' />">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/create-user'/>">Create User</a></p>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>