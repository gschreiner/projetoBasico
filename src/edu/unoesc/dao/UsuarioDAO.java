package edu.unoesc.dao;

import java.util.List;

import edu.unoesc.model.Usuario;


public interface UsuarioDAO {

	Usuario getUsuarioById (int id);
	List<Usuario> getUsuarios();
	boolean deleteUsuario(int id);
	boolean insertUsuario(Usuario p);
	boolean updateUsuario(Usuario p);
	Usuario validaLogin(String login, String senha);
	
}
