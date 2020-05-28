package edu.unoesc.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import edu.unoesc.dao.MicroondasDAO;
import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Microondas;
import edu.unoesc.model.Pessoa;

@ManagedBean(name="microMB")
@RequestScoped
public class MicroondasController implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Microondas> micros;
	private Microondas micro = new Microondas();
	
	private ArrayList<Pessoa> pessoas;

	@ManagedProperty(value="#{MicroondasDAO}")
	private MicroondasDAO microondasDAO;
	
	@ManagedProperty(value="#{PessoaDAO}")
	private PessoaDAO pessoaDao;
	
	public void save() {
		
		if (micro.getId() != 0) {
			this.microondasDAO.updateMicroondas(micro);
		}else {
			this.microondasDAO.insertMicroondas(micro);
		}
		
		micro = new Microondas();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Microondas Salva"));
		
		//return "Index";
	}
	
	public void delete(int id) {

		this.microondasDAO.deleteMicroondas(id);		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Microondas Excluida"));
		
		//return "Index";
	}
	
	public void load(int id) {
		micro = this.microondasDAO.getMicroondasById(id);		
	}
	
	
	

	public ArrayList<Microondas> getMicros() {
		micros = new ArrayList(microondasDAO.getMicroondas());
		return micros;
	}

	public void setMicros(ArrayList<Microondas> micros) {
		this.micros = micros;
	}

	public Microondas getMicro() {
		return micro;
	}

	public void setMicro(Microondas micro) {
		this.micro = micro;
	}

	public MicroondasDAO getMicroondasDAO() {
		return microondasDAO;
	}

	public void setMicroondasDAO(MicroondasDAO microondasDAO) {
		this.microondasDAO = microondasDAO;
	}

	public PessoaDAO getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDAO pessoaDao) {
		this.pessoaDao = pessoaDao;
	}


	public ArrayList<Pessoa> getPessoas() {
		pessoas = new ArrayList(pessoaDao.getPessoas());
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
