package edu.unoesc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.unoesc.model.Pessoa;

@Controller
public class PessoaController {

	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public String pessoasList(Model m, HttpSession session) {
		
		ArrayList<Pessoa> pessoas;

		if (session.getAttribute("listPessoas") != null ){
			pessoas = (ArrayList<Pessoa>) session.getAttribute("listPessoas");
		
		}else {
			pessoas = new ArrayList<>();
			session.setAttribute("listPessoas", pessoas);
		}

		
		m.addAttribute("listPessoas", pessoas);
		m.addAttribute("pessoa", new Pessoa());
		
		return "Pessoas";
	}
	
	@RequestMapping(value="/pessoaSave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("pessoa") Pessoa pessoa, HttpSession session){    
		ArrayList<Pessoa> pessoas;
		pessoas = (ArrayList<Pessoa>) session.getAttribute("listPessoas");
		
		pessoa.setId(pessoas.size());
		pessoas.add(pessoa);
		
        return "redirect:/pessoas";    
    }    

	@RequestMapping(value = "/pessoaDetail/{id}")
	public String pessoa(@PathVariable int id, Model model, HttpSession session) {
		// session.getAttribute("pessoasList");
		
		if (session.getAttribute("listPessoas") != null) {
			
			ArrayList<Pessoa> pessoas;
			pessoas = (ArrayList<Pessoa>) session.getAttribute("listPessoas");
			Pessoa user = pessoas.get(id);
			
			model.addAttribute("pessoa", user);

			return "PessoaDetail";
		}
		
		return this.pessoasList(model, session);
	}
	
	@RequestMapping(value = "/pessoaUpdate", method = RequestMethod.POST)
	public String pessoaEdit(@ModelAttribute("pessoa") Pessoa pessoa, HttpSession session) {
		
		if (session.getAttribute("listPessoas") != null) {
					
			ArrayList<Pessoa> pessoas;
			pessoas = (ArrayList<Pessoa>) session.getAttribute("listPessoas");
			pessoas.set(pessoa.getId(), pessoa);
			

			return "redirect:/pessoas";
		}
		
		return "redirect:/pessoas";
	}

}
