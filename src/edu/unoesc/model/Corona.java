package edu.unoesc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CORONA")
public class Corona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "vivo")
	private int vivo;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
	private Pessoa pessoa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getVivo() {
		return vivo;
	}

	public void setVivo(int vivo) {
		this.vivo = vivo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null && arg0 instanceof Corona) {
			Corona a = (Corona) arg0;
			boolean r;
			r = (this.id == a.id); 
			r = (r && this.pessoa.equals(pessoa));
			return r;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return id + status + vivo + pessoa.hashCode();
	}

	@Override
	public String toString() {
		return this.pessoa.getNome() + vivo;
	}
	
}
