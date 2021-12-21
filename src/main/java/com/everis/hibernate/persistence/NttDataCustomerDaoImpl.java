package com.everis.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */

public class NttDataCustomerDaoImpl implements NttDataCustomerDaoI {

		/** Conexión de la sesión */
		private Session session;

		/**
		 * Constructor del método
		 * 
		 * @param session
		 */
		public NttDataCustomerDaoImpl(Session session) {
			this.session = session;
		}

		@Override
		public void insert(NttDataCustomer insertCustomer) {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Inserción
			session.save(insertCustomer);
			session.flush();

			// Commit
			session.getTransaction().commit();

		}

		@Override
		public void update(NttDataCustomer updateCustomer) {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Inserción
			session.saveOrUpdate(updateCustomer);

			// Commit
			session.getTransaction().commit();

		}

		@Override
		public void delete(NttDataCustomer deleteCustomer) {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Inserción
			session.delete(deleteCustomer);

			// Commit
			session.getTransaction().commit();

		}

		@Override
		public NttDataCustomer searchById(Long id) {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Búsqueda por PK
			NttDataCustomer result = (NttDataCustomer) session.get(NttDataCustomer.class, id);

			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<NttDataCustomer> searchAll() {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Búsqueda de todos los clientes
			List<NttDataCustomer> list = session.createQuery("FROM NttDataCustomer").list();

			return list;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<NttDataCustomer> searchByNameAndSurname(String name, String primaryLastName, String secondLastName) {

			// Comprobación de la sesión activa
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}

			// Localizado de clientes por nombre y apellidos
			final List<NttDataCustomer> clientList = session
			        .createQuery("FROM NttDataCustomer WHERE NAME= :name AND PRIMARY_LASTNAME = :primaryLastName AND SECOND_LASTNAME= :secondLastName")
			        .setParameter("name", name).setParameter("primaryLastName", primaryLastName).setParameter("secondLastName", secondLastName).list();

			return clientList;

		}
	
}
