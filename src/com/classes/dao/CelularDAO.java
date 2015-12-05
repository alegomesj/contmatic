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

public class CelularDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Session session;

	public void save(Celular c) {
		session = HibernateUtil.getSessionfactory().openSession();

		try {
			session.getTransaction().begin();
			session.save(c);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Celular> listAll() {
		session = HibernateUtil.getSessionfactory().openSession();

		try {
			return session.createCriteria(Celular.class, "c").list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}
	
	
	
}