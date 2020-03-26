<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="models.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pessoa</title>
</head>
<body>

	<%
		List<Pessoa> pessoas;
		if (session.getAttribute("pessoas") == null) {
			pessoas = new ArrayList<Pessoa>();
			session.setAttribute("pessoas", pessoas);
		} else
			pessoas = (ArrayList<Pessoa>) session.getAttribute("pessoas");

		int pessoaId = Integer.parseInt(request.getParameter("pessoaId"));

		if (pessoas.size() < 1 || pessoas.size() < pessoaId) {
			request.getRequestDispatcher("Pessoas.jsp").forward(request, response);
		}

		Pessoa p = pessoas.get(pessoaId);
	%>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="PessoaCadastro" method="GET">
			<p>
				Nome:<input type="text" name="txtnome" value=<%=p.getNome()%> />
			</p>

			<p>
				E-Mail:<input type="text" name="txtemail" value=<%=p.getEmail()%> />
			</p>

			<p>
				Data de Nascimento:<input type="date" id="txtdtnasc"
					name="txtdtnasc" value="<%=p.getDataNasDateInput()%>" />
			</p>
			
			<input type="hidden" name="updatePessoa" value=<%=pessoaId%> /> <input
				type="submit" value="Salvar" />

		</form>
	</div>

	<a href="Pessoas.jsp"> Voltar</a>
</body>
</html>