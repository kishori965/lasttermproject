<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="link.jsp"%>
</head>
<body>
	<%@include file="user_header.jsp"%>

	<section>
		<sf:form action="user/addarticle" method="post" modelAttribute="article">
			<table>
				<tr>
					<td><label>Title</label></td>
				</tr>
				<tr>
					<td><sf:input path="titile" /></td>
				</tr>
				<tr>
					<td><label>Content</label></td>
				</tr>
				<tr>
					<td><sf:textarea path="content" rows="=10" cols="100" /></td>
				</tr>
				<tr>
					<td><sf:button type="submit">Post Article</sf:button></td>
				</tr>
			</table>
		</sf:form>
	</section>
</body>
</html>