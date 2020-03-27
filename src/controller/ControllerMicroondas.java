package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Microondas;

@WebServlet("/MicroCad")
public class ControllerMicroondas extends HttpServlet{

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}
	
	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Microondas> microondasList;
		if (req.getSession().getAttribute("microondasList") == null) {
			microondasList = new ArrayList<Microondas>();
			req.getSession().setAttribute("microondasList", microondasList);
		} else {
			microondasList = (ArrayList<Microondas>) req.getSession().getAttribute("microondasList");
		}
		Microondas micro;
		
		if (req.getParameter("hdMicroId") != null) {
			int microId = Integer.parseInt(req.getParameter("hdMicroId"));
			micro = microondasList.get(microId);
		}else {
			micro = new Microondas();
			microondasList.add(micro);
		}
		
		
		micro.setMarca(req.getParameter("txtmarca"));
		micro.setModelo(req.getParameter("txtmodelo"));
		micro.setPotencia(Integer.parseInt(req.getParameter("txtpotencia")));
		
		req.getRequestDispatcher("Microondas.jsp").forward(req, resp);
	}
}
