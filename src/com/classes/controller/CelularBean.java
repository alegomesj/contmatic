

package com.classes.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;



import com.classes.dao.CelularDAO;
import com.classes.dao.FavoritoDAO;
import com.classes.model.Celular;
import com.classes.model.Favorito;


/**
 * @author - Alexandre Jardim
 * @since - 02/12/2014
 */
@ManagedBean(name = "mbCelular")
@SessionScoped
public class CelularBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Celular> celulares;
	public FavoritoDAO getFavoritoDAO() {
		return favoritoDAO;
	}

	public void setFavoritoDAO(FavoritoDAO favoritoDAO) {
		this.favoritoDAO = favoritoDAO;
	}

	private Celular celularSelecionado;
	private CelularDAO celularDAO;
	private FavoritoDAO favoritoDAO;
	
	private List<Celular> droppedCelulares;
	
	
	private List<Favorito> favoritos;

	

	public CelularBean() {
		celularDAO = new CelularDAO();
		celulares = celularDAO.listAll();
		
		favoritoDAO = new FavoritoDAO();
		favoritos = favoritoDAO.listAll();
		
		
		droppedCelulares  = new ArrayList<Celular>();
	}
	
	public void limpar(){
		droppedCelulares = null;
		droppedCelulares  = new ArrayList<Celular>();
	}
	
	public void onCelularDrop(DragDropEvent ddEvent) {
		try{
			Celular celular = ((Celular) ddEvent.getData());
			celular.setZerarcalculados();
			
			if (droppedCelulares.size() < 2){
				droppedCelulares.add(celular);
				// celulares.remove(celular); <<Caso for para remover da Lista de Celulares
			}else{
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Você pode apenas Comparar e Celulares! Limpe a Lista", "Celulareso"));
			}
			
			if (droppedCelulares.size() > 1){
				Celular celular1 = (Celular) droppedCelulares.get(0);
				Celular celular2 = (Celular) droppedCelulares.get(1);
				
					
				if (celular1.getPreco() < celular2.getPreco()){
					celular1.setPrecoo(true);
				}else{
					celular2.setPrecoo(true);
				}
				
				if (celular1.getCamponto() > celular2.getCamponto()){
					celular1.setCamera(true);
				}else{
					celular2.setCamera(true);
				}
				
				if (celular1.getProponto() > celular2.getProponto()){
					celular1.setProcessador(true);
				}else{
					celular2.setProcessador(true);
				}
					
				if (celular1.getMemponto() > celular2.getMemponto()){
					celular1.setMemoria(true);
				}else{
					celular2.setMemoria(true);
				}	
				
				if (celular1.getTelaponto() > celular2.getTelaponto()){
					celular1.setTela(true);
				}else{
					celular2.setTela(true);
				}	
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
    }
	public void salvarFavorito(Celular celularFavorito){
		try {
			favoritoDAO.salvarFavorito(celularFavorito);
			favoritos = favoritoDAO.listAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Favorito adicionado", "Favorito adicionado"));
		}
	}
	
	
	


	public List<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}

	

	public Celular getCelularSelecionado() {
		return celularSelecionado;
	}

	public void setCelularSelecionado(Celular celularSelecionado) {
		this.celularSelecionado = celularSelecionado;
	}

	public CelularDAO getCelularDAO() {
		return celularDAO;
	}

	public void setCelularDAO(CelularDAO celularDAO) {
		this.celularDAO = celularDAO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Celular> getDroppedCelulares() {
		return droppedCelulares;
	}

	public void setDroppedCelulares(List<Celular> droppedCelulares) {
		this.droppedCelulares = droppedCelulares;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}
	
	

	
}