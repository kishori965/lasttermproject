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
		<form action="login" method="post">
			<table>
				<tr>
					<td colspan="2" align="center"><span class="errorMsgs">${errorMessage}</span></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>