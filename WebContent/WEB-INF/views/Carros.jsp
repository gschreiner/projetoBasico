<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carros</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Modelo</th>
				<th>Marca</th>
				<th>Placa</th>
<!-- 				<th>Proprietario</th> -->
			</tr>
			<c:forEach var="m" items="${listCarros}">
				<tr>
					<td>${m.modelo}</td>
					<td>${m.marca}</td>
					<td>${m.placa}</td>
<%-- 					<td>${m.pessoa.nome}</td> --%>
					<td><a href="carroDelete/${m.id}">Del</a></td>
					<td><a href="carroDetail/${m.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="carroSave" method="POST" modelAttribute="carro">
			<p>
				Modelo:
				<form:input path="carro.modelo" />
				
			</p>

			<p>
				Fabricante:
				<form:input path="carro.marca" />
				
			</p>
			
			<p>
				Placa:
				<form:input path="carro.placa" />
				
			</p>
			
<!-- 			<p> -->
<!-- 				Proprietário: -->
<%-- 				<form:select path="carro.pessoas" items="${pessoasList}" multiple="true" itemValue="id" itemLabel="nome"/> --%>
				
<!-- 			</p> -->


			<input type="submit" value="Adicionar" />

		</form>
	</div>


</body>

</html>