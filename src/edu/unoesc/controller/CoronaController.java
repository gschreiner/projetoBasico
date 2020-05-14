package edu.unoesc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.unoesc.dao.CoronaDAO;
import edu.unoesc.dao.MicroondasDAO;
import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Corona;
import edu.unoesc.model.Microondas;
import edu.unoesc.model.Pessoa;

@Controller
public class CoronaController {

	@Autowired
	private CoronaDAO coronaDao;
	
	@Autowired
	private PessoaDAO pessoaDao;

	@RequestMapping(value = "/corona", method = RequestMethod.GET)
	public String microList(Model m) {

		ArrayList<Corona> coronaList = new ArrayList(coronaDao.getCorona());

		m.addAttribute("coronaList", coronaList);
		Corona c = new Corona();
		c.setVivo(1);
		m.addAttribute("corona", c);
		m.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "Corona";
	}

	@RequestMapping(value = "/coronaSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("corona") Corona corona) {

		this.coronaDao.insertCorona(corona);

		return "redirect:/corona";
	}
	
//	@RequestMapping(value = "/microDelete/{id}")
//	public String microDelete(@PathVariable int id, Model model) {
//
//		if (this.coronaDao.deleteMicroondas(id))
//			System.out.print("/t -> Deu boa/n");
//		else
//			System.out.print("Deu caca");
//		
//		return "redirect:/microondas";
//	}
//	
	@RequestMapping(value = "/coronaDetail/{id}")
	public String microDetail(@PathVariable int id, Model model) {

		Corona m = this.coronaDao.getCoronaById(id);

		model.addAttribute("corona", m);
		model.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "CoronaDetail";

	}
//	
	@RequestMapping(value = "/coronaUpdate", method = RequestMethod.POST)
	public String microEdit(@ModelAttribute("corona") Corona corona) {

		this.coronaDao.updateCorona(corona);

		return "redirect:/corona";
	}
}
