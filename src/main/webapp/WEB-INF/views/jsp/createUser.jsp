<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateUser</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear un usuario</h1>
	<form:form action="create-user" modelAttribute="user">
		<p>UserName:
			<form:input path="username" placeholder="username" required="required" />

		</p>
		<p>Email:
			<form:input path="email" placeholder="email" required="required" />

		</p>
		<p>Password:
			<form:input path="password" placeholder="password" />
		</p>
		<p>Birthdate:
			<form:input path="birthDate" placeholder="birthDate" />
		</p>

		<p><input type="submit" value="Crear usuario"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>