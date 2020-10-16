package com.zeroseis.impactamais.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_postagem")
public class Postagem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 120)
	private String titulo;
	
	@NotNull
	@Size(min = 1, max = 2200)
	private String text_box;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_post = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	@Size(min = 1, max = 120)
	private String cidade;
	
	@NotNull
	@Size(min =2, max = 30)
	private String sangue;	
	
	@NotNull
	@Size(min =2, max = 120)
	private String nome_hospital;	
	
	
	@Size(min =0, max = 8000)
	private String imagem;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getText_box() {
		return text_box;
	}

	public void setText_box(String text_box) {
		this.text_box = text_box;
	}

	public Date getData_post() {
		return data_post;
	}

	public void setData_post(Date data_post) {
		this.data_post = data_post;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSangue() {
		return sangue;
	}

	public void setSangue(String sangue) {
		this.sangue = sangue;
	}

	public String getNome_hospital() {
		return nome_hospital;
	}

	public void setNome_hospital(String nome_hospital) {
		this.nome_hospital = nome_hospital;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	
}
