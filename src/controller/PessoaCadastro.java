package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pessoa;

@WebServlet("/PessoaCadastro")
public class PessoaCadastro extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		
		Pessoa p;
		
		List <Pessoa> pessoas;
		if (req.getSession().getAttribute("pessoas")== null){
			pessoas = new ArrayList<Pessoa>();
			req.getSession().setAttribute("pessoas", pessoas);
		}else{
			pessoas = (ArrayList)req.getSession().getAttribute("pessoas");
		}
		
		
		if (req.getParameter("updatePessoa")!= null) {
			int pId = Integer.parseInt(req.getParameter("updatePessoa")); 
			p = pessoas.get(pId);
		} else {
			p = new Pessoa();
			pessoas.add(p);
		}
		
		p.setNome(req.getParameter("txtnome"));
		p.setEmail(req.getParameter("txtemail"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			p.setDataNasc(format.parse(req.getParameter("txtdtnasc")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//req.setAttribute(GREETING_REQUEST_PARAMETER_KEY, greeting);
		req.getRequestDispatcher("Pessoas.jsp").forward(req, resp);
	}

}
