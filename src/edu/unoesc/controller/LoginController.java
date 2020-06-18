package edu.unoesc.controller;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.sun.istack.NotNull;

import edu.unoesc.dao.UsuarioDAO;

import edu.unoesc.dao.PessoaDAO;
import edu.unoesc.model.Usuario;
import edu.unoesc.utils.SessionContext;
import edu.unoesc.model.Pessoa;

@ManagedBean(name="usuarioMB")
@RequestScoped
public class LoginController {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> listUsuario;
	
	private boolean logado = false;
	
	@ManagedProperty(value="#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;
	
	public LoginController() {
		logado = (SessionContext.getInstance().getAttribute("usuarioLogado")!= null);
	}

	public void save() {
		this.usuario.setSenha(this.encryptSenha(this.getUsuario().getSenha()));
		if (usuario.getId() == 0) {
			this.usuarioDao.insertUsuario(usuario);
		} else {
			this.usuarioDao.updateUsuario(usuario);
		}
		
		usuario = new Usuario();
	}
	
	
	public void usuarioEdit() {

		this.usuarioDao.updateUsuario(usuario);
	}
	
	
	public void usuarioDelete(int id) {
		this.usuarioDao.deleteUsuario(id);
	}
	
	public void load (int id) {
		this.usuario = usuarioDao.getUsuarioById(id);
	}

	public String fazLogin() {
		FacesMessage message = null;
        
		usuario = usuarioDao.validaLogin(this.getUsuario().getLogin(), this.encryptSenha(this.getUsuario().getSenha()));
		
		if (usuario	!=	null) {
			logado = true;
			SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login realizado com sucesso!", this.getUsuario().getLogin());
		}else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no Login!", "Usuário ou senha inválido");
			SessionContext.getInstance().setAttribute("usuarioLogado", null);
			logado = false;
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
			
		}
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", logado);
        return "/views/Index.html";
	}
	
	
	public void fazLogout() {
		FacesMessage message = null;
        
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout!","Até mais.");
			SessionContext.getInstance().setAttribute("usuarioLogado", null);
			logado = false;
			usuario = new Usuario();
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        //PrimeFaces.current().ajax().addCallbackParam("loggedIn", logado);
	}
	
	
	private String encryptSenha (String senha) {
		MessageDigest mDigest;
		  try { 
		      //Instanciamos o nosso HASH MD5, poderíamos usar outro como
		      //SHA, por exemplo, mas optamos por MD5.
		      mDigest = MessageDigest.getInstance("MD5");
		       
		      //Convert a String valor para um array de bytes em MD5
		      byte[] valorMD5 = mDigest.digest(senha.getBytes("UTF-8"));
		       
		      //Convertemos os bytes para hexadecimal, assim podemos salvar
		      //no banco para posterior comparação se senhas
		      StringBuffer sb = new StringBuffer();
		      for (byte b : valorMD5){
		             sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
		      }
		 
		      return sb.toString();
		       
		  } catch (NoSuchAlgorithmException e) {
		      e.printStackTrace();
		      return null;
		  } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		      return null;
		  }
	}
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getListUsuario() {
		listUsuario = usuarioDao.getUsuarios();
		return listUsuario;
	}


	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}


	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public boolean isLogado() {
		return logado;
	}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	
	
}