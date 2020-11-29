<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="link.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<section>
		<sf:form action="signup" method="POST" modelAttribute="user">
			<table>
				<tr>
					<td colspan="2" align="center">${errroMessage}</td>
				</tr>
				<tr>
					<td><label>Full Name</label></td>
					<td><sf:input path="fullname" /></td>
					<td><span class="errorMsgs">${errorMessages.fullnameError}</span></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><sf:input path="email" /></td>
					<td><span class="errorMsgs">${errorMessages.emailError}</span></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><sf:input path="password" /></td>
					<td><span class="errorMsgs">${errorMessages.passwordError}</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><sf:button type="submit">Sign Up</sf:button></td>
				</tr>
			</table>
		</sf:form>
	</section>
</body>
</html>