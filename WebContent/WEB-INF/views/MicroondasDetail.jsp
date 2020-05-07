<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Microondas</title>
</head>
<body>


	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="/ProjetoBasico/microUpdate" method="POST" modelAttribute="micro">
		<form:hidden path="micro.id" />
			<p>
				Modelo:
				<form:input path="micro.modelo" />
				
			</p>

			<p>
				Fabricante:
				<form:input path="micro.fabricante" />
				
			</p>
			
			<p>
				Proprietário:
				<form:select path="micro.pessoa.id">
                    <form:option value="-1" label="--Selecione Proprietário"/>
                    <form:options items="${pessoasList}" itemValue="id" itemLabel="nome"/>
                </form:select>
				
			</p>


			<input type="submit" value="Adicionar" />

		</form>
	</div>


	<a href="/ProjetoBasico/microondas"> Voltar</a>
</body>
</html>