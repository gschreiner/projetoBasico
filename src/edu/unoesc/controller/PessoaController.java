package edu.unoesc.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Pessoa;

@ManagedBean(name="pessoaMB")
@RequestScoped
public class PessoaController implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pessoa> pessoas;
	private Pessoa pessoa = new Pessoa();	

	@ManagedProperty(value="#{PessoaDAO}")
	private PessoaDAO pessoaDao;
	

	//@RequestMapping(value = "/pessoaSave", method = RequestMethod.POST)
	public void save() {
		
		if (pessoa.getId() != 0) {
			this.pessoaDao.updatePessoa(pessoa);
		}else {
			this.pessoaDao.insertPessoa(pessoa);
		}
		
		pessoa = new Pessoa();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Salva"));
		
		//return "Index";
	}
	
	public void delete(int id) {

		this.pessoaDao.deletePessoa(id);		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Excluida"));
		
		//return "Index";
	}
	
	public void load(int id) {

		pessoa = this.pessoaDao.getPessoaById(id);		
		
		//return "Index";
	}
	
	
	public ArrayList<Pessoa> getPessoas() {
		//if (pessoaDao == null) pessoaDao = new PessoaDAOImpl();
		pessoas = new ArrayList(pessoaDao.getPessoas());
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaDAO getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDAO pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

//	@RequestMapping(value = "/pessoaDetail/{id}")
//	public String pessoa(@PathVariable int id, Model model) {
//
//		Pessoa user = this.pessoaDao.getPessoaById(id);
//
//		model.addAttribute("pessoa", user);
//
//		return "PessoaDetail";
//
//	}
//
//	@RequestMapping(value = "/pessoaUpdate", method = RequestMethod.POST)
//	public String pessoaEdit(@ModelAttribute("pessoa") Pessoa pessoa) {
//
//		this.pessoaDao.updatePessoa(pessoa);
//
//		return "redirect:/pessoas";
//	}
	
	

}
