package com.classes.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * @author - Alexandre Jardim
 * @since - 02/12/2014
 */

@Entity
@Table(name = "FAVORITO")
public class Favorito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="CODIGO")
	private Celular codigo;
	@Column(name = "PONTOS")  //PONTOS
	private int pontos;
	public Celular getCodigo() {
		return codigo;
	}
	public void setCodigo(Celular codigo) {
		this.codigo = codigo;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}