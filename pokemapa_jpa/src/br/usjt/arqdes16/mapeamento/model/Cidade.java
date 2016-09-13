package br.usjt.arqdes16.mapeamento.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "idCidade")
	public int id;
	@NotNull
	@Size(max = 128)
	@Column(name = "nmCidade")
	public String nome;
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idUF")
	public Estado estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getUf() {
		return estado;
	}

	public void setUf(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", uf=" + estado + "]";
	}
}