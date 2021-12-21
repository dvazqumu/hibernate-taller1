package com.everis.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */
public class NttDataHibernateUtil {

	/**
	 * Session Factory
	 */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Generación de Session Factory
	 */
	static {

		try {

			// Generación de la configuración
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable ex) {

			// Error de inicialización
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Return del Session Factory
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
