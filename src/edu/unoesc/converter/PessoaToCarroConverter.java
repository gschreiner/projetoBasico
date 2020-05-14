package edu.unoesc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Pessoa;

@Component
public class PessoaToCarroConverter implements Converter<Object, Pessoa>{
	@Autowired
	PessoaDAO pessoaDAO;

	@Override
	public Pessoa convert(Object source) {
		Integer id = Integer.parseInt((String)source);
		Pessoa pessoa= pessoaDAO.getPessoaById(id);
		
		return pessoa;
	}
	
	
}