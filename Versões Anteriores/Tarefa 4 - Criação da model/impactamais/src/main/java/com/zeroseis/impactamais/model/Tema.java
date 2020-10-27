package com.zeroseis.impactamais.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tema")

public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tema;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String pedido;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String ajudei;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String info;

	public long getId_tema() {
		return id_tema;
	}

	public void setId_tema(long id_tema) {
		this.id_tema = id_tema;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getAjudei() {
		return ajudei;
	}

	public void setAjudei(String ajudei) {
		this.ajudei = ajudei;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
