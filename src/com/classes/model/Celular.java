package com.classes.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author - Alexandre Jardim
 * @since - 02/12/2014
 */

@Entity
@Table(name = "CELULAR")
public class Celular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO")
	private long codigo;
	@Column(name = "NOME")  //Nome do Celular
	private String nome;
	@Column(name = "PRECO") //Preço
	private double preco;
	@Column(name = "CAMDESCRI") //Definição da Camera
	private String camdescri; 
	@Column(name = "CAMPONTO")  //Pontos para a Camera
	private int camponto;
	@Column(name = "PRODESCRI") //Nome do Processador
	private String prodescri;
	@Column(name = "PROPONTO") //Pontos para o Processador
	private int proponto;
	@Column(name = "MEMDESCRI") //Descrição da Memoria
	private String mendescri;
	@Column(name = "MEMPONTO") //Pontos para a Memoria
	private int memponto;
	@Column(name = "TELADESCRI") //Descrição da Tela
	private String teladescri;
	@Column(name = "TELAPONTO") //Pontos para a Tela
	private int telaponto;
	@Column(name = "RADIOSN")  //Tem Raio
	private boolean radiosn;
	@Column(name = "TVSN")   //Tem TV
	private boolean tvsn;
	
	
	private boolean precoo;
	private boolean camera;
	private boolean processador;
	private boolean memoria;
	private boolean tela;
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCamdescri() {
		return camdescri;
	}
	public void setCamdescri(String camdescri) {
		this.camdescri = camdescri;
	}
	public int getCamponto() {
		return camponto;
	}
	public void setCamponto(int camponto) {
		this.camponto = camponto;
	}
	public String getProdescri() {
		return prodescri;
	}
	public void setProdescri(String prodescri) {
		this.prodescri = prodescri;
	}
	public int getProponto() {
		return proponto;
	}
	public void setProponto(int proponto) {
		this.proponto = proponto;
	}
	public String getMendescri() {
		return mendescri;
	}
	public void setMendescri(String mendescri) {
		this.mendescri = mendescri;
	}
	public int getMemponto() {
		return memponto;
	}
	public void setMemponto(int memponto) {
		this.memponto = memponto;
	}
	public String getTeladescri() {
		return teladescri;
	}
	public void setTeladescri(String teladescri) {
		this.teladescri = teladescri;
	}
	public int getTelaponto() {
		return telaponto;
	}
	public void setTelaponto(int telaponto) {
		this.telaponto = telaponto;
	}
	public boolean isRadiosn() {
		return radiosn;
	}
	public void setRadiosn(boolean radiosn) {
		this.radiosn = radiosn;
	}
	public boolean isTvsn() {
		return tvsn;
	}
	public void setTvsn(boolean tvsn) {
		this.tvsn = tvsn;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isPrecoo() {
		return precoo;
	}
	public void setPrecoo(boolean precoo) {
		this.precoo = precoo;
	}
	public boolean isCamera() {
		return camera;
	}
	public void setCamera(boolean camera) {
		this.camera = camera;
	}
	public boolean isProcessador() {
		return processador;
	}
	public void setProcessador(boolean processador) {
		this.processador = processador;
	}
	public boolean isMemoria() {
		return memoria;
	}
	public void setMemoria(boolean memoria) {
		this.memoria = memoria;
	}
	public boolean isTela() {
		return tela;
	}
	public void setTela(boolean tela) {
		this.tela = tela;
	}
	
	
	public void setZerarcalculados(){
		this.setPrecoo(false);
		this.setCamera(false);
		this.setProcessador(false);
		this.setMemoria(false);
		this.setTela(false);
		
	}
}