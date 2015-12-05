package com.classes.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.classes.model.Celular;
import com.classes.model.Favorito;
import com.classes.util.HibernateUtil;

/**
 * @author - Alexandre Jardim
 * @since - 02/12/2014
 */

public class FavoritoDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Session session;

	

	@SuppressWarnings("unchecked")
	public List<Favorito> listAll() {
		session = HibernateUtil.getSessionfactory().openSession();

		try {
			return session.createCriteria(Favorito.class, "f").list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
	
	public void salvarFavorito(Celular celular){
		session = HibernateUtil.getSessionfactory().openSession();

		try {
			Criteria cr = session.createCriteria(Favorito.class);
			cr.add(Restrictions.eq("codigo", celular));
			
			Favorito favorito = (Favorito) cr.uniqueResult();
			
			if (favorito == null){
				favorito = new Favorito();
				
				favorito.setCodigo(celular);
				favorito.setPontos(1);				
			}else{
				favorito.setPontos(favorito.getPontos() +1);
			}
				
			//session.save(favorito);
			session.getTransaction().begin();
			session.saveOrUpdate(favorito);
			session.getTransaction().commit();
			
			
			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
}