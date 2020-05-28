package edu.unoesc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Pessoa;

@FacesConverter(value = "pessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Pessoa p = (Pessoa) component.getAttributes().get(value);
            return p;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Pessoa)) {
			Pessoa p = (Pessoa) value; 
			component.getAttributes().put( String.valueOf(p.getId()), p);
            return String.valueOf(p.getId());
        }

		return null;
	}

}
