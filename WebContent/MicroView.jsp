<%@page import="java.util.ArrayList"%>
<%@page import="models.Microondas"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes Micro</title>
</head>
<body>

<%
		List<Microondas> microondasList;
		if (session.getAttribute("microondasList") == null) {
			microondasList = new ArrayList<Microondas>();
			session.setAttribute("microondasList", microondasList);
		} else
			microondasList = (ArrayList<Microondas>) session.getAttribute("microondasList");
		
		int microId = Integer.parseInt(request.getParameter("microId"));
		
		Microondas micro = microondasList.get(microId);

	%>
	
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="MicroCad" method="GET">
            <p>Marca:<input type="text" name="txtmarca" value="<%=micro.getMarca() %>" /></p>
            
            <p>Modelo:<input type="text" name="txtmodelo" value="<%=micro.getModelo() %>" /></p>
            
            <p>Potencia:<input type="text" name="txtpotencia" value="<%=micro.getPotencia() %>" /></p>
            
            <input type="hidden" name="hdMicroId" value="<%= microId %>" />
            
            <input type="submit" value="Editar" />
 
        </form>
	</div>
	
	<a href="Microondas.jsp"> Voltar</a>

</body>
</html>