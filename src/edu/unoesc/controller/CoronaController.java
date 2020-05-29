package edu.unoesc.controller;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.unoesc.dao.CoronaDAO;

import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Corona;

import edu.unoesc.model.Pessoa;

@ManagedBean(name="coronaMB")
@RequestScoped
public class CoronaController {
	
	private Corona corona = new Corona();
	private List<Corona> listCorona;
	private List<Pessoa> pessoas;
	
	private boolean estaVivo;
	

	@ManagedProperty(value="#{CoronaDAO}")
	private CoronaDAO coronaDao;
	
	@ManagedProperty(value="#{PessoaDAO}")
	private PessoaDAO pessoaDao;

	public void save() {
		
		if (estaVivo)
			corona.setVivo(1);
		else
			corona.setVivo(0);
		
		if (corona.getId() == 0) {
			this.coronaDao.insertCorona(corona);
		} else {
			this.coronaDao.updateCorona(corona);
		}
		
		corona = new Corona();
	}
	
	
	public void coronaEdit() {

		this.coronaDao.updateCorona(corona);
	}
	
	
	public void coronaDelete(int id) {
		this.coronaDao.deleteCorona(id);
	}
	
	public void load (int id) {
		this.corona = coronaDao.getCoronaById(id);
		this.estaVivo = (corona.getVivo() > 0);
	}


	
	
	public Corona getCorona() {
		return corona;
	}


	public void setCorona(Corona corona) {
		this.corona = corona;
	}


	public List<Corona> getListCorona() {
		listCorona = coronaDao.getCoronas();
		return listCorona;
	}


	public void setListCorona(List<Corona> listCorona) {
		this.listCorona = listCorona;
	}


	public CoronaDAO getCoronaDao() {
		return coronaDao;
	}


	public void setCoronaDao(CoronaDAO coronaDao) {
		this.coronaDao = coronaDao;
	}


	public PessoaDAO getPessoaDao() {
		return pessoaDao;
	}


	public void setPessoaDao(PessoaDAO pessoaDao) {
		this.pessoaDao = pessoaDao;
	}


	public List<Pessoa> getPessoas() {
		pessoas = pessoaDao.getPessoas();
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


	public boolean isEstaVivo() {
		return estaVivo;
	}


	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
	
	
	
}