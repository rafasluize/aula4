package br.usjt.arqdes16.mapeamento.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "idLocal")
	private int id;
	@NotNull
	@Size(max = 128, min = 5, message = "O tamanho m�ximo do nome est� entre 5 e 128 caracteres")
	@Column(name = "nmLocal")
	private String nome;
	@NotNull
	@DecimalMax(value = "5.27", message = "latitude m�xima do Brasil � 5.27 (Roraima)")
	@DecimalMin(value = "-33.75", message = "latitude m�nima do Brasil � -33.75 (Chu�)")
	private double latitude;
	// incluindo Fernando de Noronha
	@NotNull
	@DecimalMax(value = "-32.38", message = "longitude m�xima do Brasil � -32.38(Fernando de Noronha)")
	@DecimalMin(value = "-73.97", message = "longitude m�nima do Brasil � -73.97 (Acre)")
	private double longitude;
	@Size(max = 128, min = 5, message = "O tamanho m�ximo do nome da imagem est� entre 5 e128 caracteres")
	private String imagem;
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCidade")
	private Cidade cidade;
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idTipoLocal")
	private Tipo tipo;

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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", imagem=" + imagem + ", cidade=" + cidade + ", tipo=" + tipo + "]";
	}
}