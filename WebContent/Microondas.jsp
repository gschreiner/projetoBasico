<%@page import="java.util.ArrayList"%>
<%@page import="models.Microondas"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Microondas</title>
</head>
<body>

	<%
		List<Microondas> microondasList;
		if (session.getAttribute("microondasList") == null) {
			microondasList = new ArrayList<Microondas>();
			session.setAttribute("microondasList", microondasList);
		} else
			microondasList = (ArrayList<Microondas>) session.getAttribute("microondasList");

	%>
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse; ">
	
	<% if (microondasList.size() == 0) {%>
		<p>Não há microondas cadastrados</p>
	<% } else {%>
		<table style="width:100%">
  			<tr>
			    <th>Marca</th>
			    <th>Modelo</th>
			    <th>Potencia</th>
 			 </tr>
			<% for (Microondas micro : microondasList){ 
				out.print("<tr style=\"border: 1px solid black;\"> "+
								"<td style=\"border: 1px solid black;\"> "+micro.getMarca()+"</td>"+
								"<td style=\"border: 1px solid black;\"> "+micro.getModelo()+"</td>"+
								"<td style=\"border: 1px solid black;\"> "+micro.getPotencia()+"</td>"+
								"<td style=\"border: 1px solid black;\">  <a href=\"MicroView.jsp?microId="+microondasList.indexOf(micro)+"\"> View</a></td>"+
							"</tr>");
			} %>
		</table>
	<% } %>
	</div>
	
	<div style="position: relative; display: inline-block; width: 50%;margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="MicroCad" method="GET">
            <p>Marca:<input type="text" name="txtmarca" /></p>
            
            <p>Modelo:<input type="text" name="txtmodelo" /></p>
            
            <p>Potencia:<input type="text" name="txtpotencia" /></p>
            
            <input type="submit" value="Cadastrar" />
 
        </form>
	</div>

</body>
</html>