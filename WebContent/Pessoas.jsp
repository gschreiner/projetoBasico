<%@page import="java.util.ArrayList"%>
<%@page import="models.Pessoa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Pessoas</title>
</head>
<body>

<%
		List<Pessoa> pessoas;
		if (session.getAttribute("pessoas") == null) {
			pessoas = new ArrayList<Pessoa>();
			session.setAttribute("pessoas", pessoas);
		} else
			pessoas = (ArrayList<Pessoa>) session.getAttribute("pessoas");

	%>
	
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse; ">
<!-- 	listar as pessoas em uma Tabela -->
 	<% if (pessoas.size() > 0) {%>
		<table style="width:100%">
  			<tr>
			    <th>Nome</th>
			    <th>email</th>
			    <th>Data Nascimento</th>
 			 </tr>
			<% for (Pessoa p : pessoas){ 
				out.print("<tr style=\"border: 1px solid black;\"> "+
								"<td style=\"border: 1px solid black;\"> "+p.getNome()+"</td>"+
								"<td style=\"border: 1px solid black;\"> "+p.getEmail()+"</td>"+
								"<td style=\"border: 1px solid black;\"> "+p.getDataNasFormated()+"</td>"+
										"<td style=\"border: 1px solid black;\">  <a href=\"PessoaCRUD.jsp?pessoaId="+pessoas.indexOf(p)+"\"> View</a></td>"+
							"</tr>");
			} %>
		</table>
	<%} else { %>
		<p> Não há pessoas cadastradas</p>
	<%} %>
	</div>

	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
        <form action="PessoaCadastro" method="GET">
            <p>Nome:<input type="text" name="txtnome" /></p>
            
            <p>E-Mail:<input type="text" name="txtemail" /></p>
            
            <p>Data de Nascimento:<input type="date" name="txtdtnasc" /></p>
            
            <input type="submit" value="Cadastrar" />
 
        </form>
 	</div>
	
	<a href="Index.jsp"> Voltar</a>
</body>

</html>