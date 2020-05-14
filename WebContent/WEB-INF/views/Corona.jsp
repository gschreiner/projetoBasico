<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Status</th>
				<th>Vivo</th>
				<th>Pessoa</th>
			</tr>
			<c:forEach var="m" items="${coronaList}">
				<tr>
					<td>${m.status}</td>
					<td>${m.vivo}</td>
					<td>${m.pessoa.nome}</td>
<%-- 					<td><a href="microDelete/${m.id}">Del</a></td> --%>
					<td><a href="coronaDetail/${m.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="coronaSave" method="POST" modelAttribute="corona">
			<p>
				Status:
				<form:select path="corona.status">
                    <form:option value="0" label="Suspeito"/>
                    <form:option value="1" label="Confirmado"/>
                    <form:option value="2" label="Curado"/>
                </form:select>
				
			</p>

			<p>
				Vivo:
				<form:select path="corona.vivo">
                    <form:option value="1" label="Vivo"/>
                    <form:option value="0" label="Morto"/>
                </form:select>
				
			</p>
			
			<p>
				Pessoa:
				<form:select path="corona.pessoa.id">
<%--                     <form:option value="-1" label="--Selecione Proprietário"/> --%>
                    <form:options items="${pessoasList}" itemValue="id" itemLabel="nome"/>
                </form:select>
				
			</p>


			<input type="submit" value="Adicionar" />

		</form>
	</div>

 <a href="/ProjetoBasico">voltar</a>
</body>

</html>