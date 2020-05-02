<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pessoas</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Modelo</th>
				<th>Fabricante</th>
			</tr>
			<c:forEach var="m" items="${listMicro}">
				<tr>
					<td>${m.modelo}</td>
					<td>${m.fabricante}</td>
					<td><a href="microDelete/${m.id}">Del</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="microSave" method="POST" modelAttribute="micro">
			<p>
				Modelo:
				<form:input path="micro.modelo" />
				
			</p>

			<p>
				Fabricante:
				<form:input path="micro.fabricante" />
				
			</p>


			<input type="submit" value="Adicionar" />

		</form>
	</div>


</body>

</html>