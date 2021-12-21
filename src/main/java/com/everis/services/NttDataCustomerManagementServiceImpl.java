package com.everis.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.everis.hibernate.persistence.NttDataCustomer;
import com.everis.hibernate.persistence.NttDataCustomerDaoI;
import com.everis.hibernate.persistence.NttDataCustomerDaoImpl;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */

public class NttDataCustomerManagementServiceImpl implements NttDataCustomerManagementServiceI {

	/** DAO: NTTDATA_CUSTOMER */
	private NttDataCustomerDaoI customerDao;

	/**
	 * Método del constructor
	 */
	public NttDataCustomerManagementServiceImpl(final Session session) {
		this.customerDao = new NttDataCustomerDaoImpl(session);
	}

	/**
	 * Insertado de cliente
	 */
	@Override
	public void insertNewCustomer(NttDataCustomer newCustomer) {

		// Verificación de si es null
		if (newCustomer != null && newCustomer.getId() == null) {

			// Inserción de cliente
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(NttDataCustomer updateCustomer) {

		// Verificación de si es null
		if (updateCustomer != null && updateCustomer.getId() == null) {

			// Actualización de cliente
			customerDao.update(updateCustomer);
		}

	}

	@Override
	public void deleteCustomer(NttDataCustomer deleteCustomer) {

		// Verificación de si es null
		if (deleteCustomer != null && deleteCustomer.getId() != null) {

			// Borrado de cliente
			customerDao.delete(deleteCustomer);
		}

	}

	@Override
	public NttDataCustomer searchById(Long customerId) {

		// Resultado de búsqueda
		NttDataCustomer customer = null;

		// Verificación de si es null
		if (customerId != null) {

			// Obtención de cliente por ID
			customer = customerDao.searchById(customerId);
		}

		return customer;

	}

	@Override
	public List<NttDataCustomer> searchAll() {

		// Consulta de todos los clientes
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes
		list = customerDao.searchAll();

		return list;

	}

	@Override
	public List<NttDataCustomer> searchByName(String name, String firstSurname, String secondSurname) {

		// Consulta de todos los clientes
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes
		list = customerDao.searchByNameAndSurname(name, firstSurname, secondSurname);

		return list;

	}
	
}
