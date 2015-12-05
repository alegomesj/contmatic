package com.classes.util;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.classes.model.Celular;
import com.classes.model.Favorito;

/**
* @author - Alexandre Jardim
 * @since - 02/12/2014
 */


public class HibernateUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure()
					.addPackage("com.classes.model")
					.addAnnotatedClass(Celular.class)
					.addAnnotatedClass(Favorito.class).buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}