<%@page import="java.util.ArrayList"%>
<%@page import="beans.Pessoa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Titulo</title>
</head>
<body>
<%-- 	<%@include file="topo.jsp"%> --%>
<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
        <form action="PessoaCRUD.jsp" method="GET">
            Nome:<input type="text" name="txtnome" /><br>
            
            E-Mail:<input type="text" name="txtemail" /><br>
            
            Data de Nascimento:<input type="text" name="txtdtnasc" /><br>
            
            <input type="submit" value="Enviar" />
 
        </form>


	<select id="cars" name="cars">
		<option value="volvo">Volvo</option>
		<option value="saab">Saab</option>
		<option value="fiat">Fiat</option>
		<option value="audi">Audi</option>
	</select>

	<% int j = 0; %>
    <% String var = "String"; %>
	<%
		List<Pessoa> pessoas;
		if (session.getAttribute("pessoas") == null) {
			pessoas = new ArrayList<Pessoa>();
			session.setAttribute("pessoas", pessoas);
		} else
			pessoas = (ArrayList<Pessoa>) session.getAttribute("pessoas");

		out.print(" Tamanho: " + pessoas.size());
	%>
<!-- 	listar as pessoas em um combo -->
		<select id="pes" name="pessoas">
		<% for (Pessoa p : pessoas){ 
			out.print("<option value=\""+p.getNome()+"\" >"+p.getNome()+"</option>");
		} %>
	</select>

	
<%--    <%@include file="rodape.jsp"%> --%>
</body>

</html>