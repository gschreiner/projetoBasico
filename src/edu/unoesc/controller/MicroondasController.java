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

import edu.unoesc.dao.MicroondasDAO;
import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Microondas;
import edu.unoesc.model.Pessoa;

@Controller
public class MicroondasController {

	@Autowired
	private MicroondasDAO microDao;
	
	@Autowired
	private PessoaDAO pessoaDao;

	@RequestMapping(value = "/microondas", method = RequestMethod.GET)
	public String microList(Model m) {

		ArrayList<Microondas> micros = new ArrayList(microDao.getMicroondas());

		m.addAttribute("listMicro", micros);
		m.addAttribute("micro", new Microondas());
		m.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "Microondas";
	}

	@RequestMapping(value = "/microSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("micro") Microondas micro) {

		this.microDao.insertMicroondas(micro);

		return "redirect:/microondas";
	}
	
	@RequestMapping(value = "/microDelete/{id}")
	public String microDelete(@PathVariable int id, Model model) {

		if (this.microDao.deleteMicroondas(id))
			System.out.print("/t -> Deu boa/n");
		else
			System.out.print("Deu caca");
		
		return "redirect:/microondas";
	}
	
	@RequestMapping(value = "/microDetail/{id}")
	public String microDetail(@PathVariable int id, Model model) {

		Microondas m = this.microDao.getMicroondasById(id);

		model.addAttribute("micro", m);
		model.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "MicroondasDetail";

	}
	
	@RequestMapping(value = "/microUpdate", method = RequestMethod.POST)
	public String microEdit(@ModelAttribute("micro") Microondas micro) {

		this.microDao.updateMicroondas(micro);

		return "redirect:/microondas";
	}
}
