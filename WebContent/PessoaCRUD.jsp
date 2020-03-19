<%@page import="java.util.*"%>
<%@page import="beans.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
			
<!-- 			Aqui estamos pegando os valores que vieram pelo formulário da página Main -->
		<% if (request.getParameter("txtnome")!= null) {%>
			<p>Nome: <%=request.getParameter("txtnome") %></p>
		<% }%>
		<% if (request.getParameter("txtemail")!= null) {%>
			<p>EMail: <%=request.getParameter("txtemail") %></p>
		<% }%>
		<% if (request.getParameter("txtdtnasc")!= null) {%>
			<p>Nome: <%=request.getParameter("txtdtnasc") %></p>
		<% }%>
		
		
<!-- 		Aqui estamos criando o objeto pessoa e armazenando no session para acessar eles na outra pagina -->
		<% 
			Pessoa p = new Pessoa();
			p.setNome(request.getParameter("txtnome"));
			p.setIdade(10);
			
			List <Pessoa> pessoas;
			if (session.getAttribute("pessoas")== null){
				pessoas = new ArrayList<Pessoa>();
				session.setAttribute("pessoas", pessoas);
			}else
				pessoas = (ArrayList)session.getAttribute("pessoas");
			
			pessoas.add(p);
		%>
		
		<a href="Main.jsp"> Voltar</a>
	</body>
</html>