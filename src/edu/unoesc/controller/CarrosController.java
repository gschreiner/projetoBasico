package edu.unoesc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.unoesc.dao.CarrosDAO;
import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Carro;
import edu.unoesc.model.Pessoa;

@Controller
public class CarrosController {

	@Autowired
	private CarrosDAO carroDao;
	
	@Autowired
	private PessoaDAO pessoaDao;

	@RequestMapping(value = "/carros", method = RequestMethod.GET)
	public String carroList(ModelMap m) {

		ArrayList<Carro> carros = new ArrayList(carroDao.getCarros());

		m.addAttribute("listCarros", carros);
		m.addAttribute("carro", new Carro());
		m.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "Carros";
	}

	@RequestMapping(value = "/carroSave", method = RequestMethod.POST)
	public String save(@ModelAttribute("carro") Carro carro) {
		
	//	carro.getPessoas().add(pessoaDao.getPessoaById(2));
		this.carroDao.insertCarros(carro);

		return "redirect:/carros";
	}
	
	@RequestMapping(value = "/carroDelete/{id}")
	public String carroDelete(@PathVariable int id, Model model) {

		if (this.carroDao.deleteCarros(id))
			System.out.print("/t -> Deu boa/n");
		else
			System.out.print("Deu caca");
		
		return "redirect:/carros";
	}
	
	@RequestMapping(value = "/carroDetail/{id}")
	public String carroDetail(@PathVariable int id, Model model) {

		Carro m = this.carroDao.getCarrosById(id);

		model.addAttribute("carro", m);
		model.addAttribute("pessoasList", pessoaDao.getPessoas());

		return "CarrosDetail";

	}
	
	@RequestMapping(value = "/carroUpdate", method = RequestMethod.POST)
	public String carroEdit(@ModelAttribute("carro") Carro carro) {

		this.carroDao.updateCarros(carro);

		return "redirect:/carros";
	}
}
