package com.everis.services;

import java.util.List;

import com.everis.hibernate.persistence.NttDataCustomer;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */

public interface NttDataCustomerManagementServiceI {

	/**
	 * Insertado de cliente
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final NttDataCustomer newCustomer);

	/**
	 * Actualizado de cliente
	 * 
	 * @param updateCustomer
	 */
	public void updateCustomer(final NttDataCustomer updateCustomer);

	/**
	 * Borrado de cliente
	 * 
	 * @param deleteCustomer
	 */
	public void deleteCustomer(final NttDataCustomer deleteCustomer);

	/**
	 * Obtención de cliente por ID
	 * 
	 * @param customerId
	 */
	public NttDataCustomer searchById(final Long customerId);

	/**
	 * Obtención de todos los clientes
	 * 
	 * @param customerId
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchAll();

	/**
	 * Obtención de cliente por nombre y apellidos
	 * 
	 * @param name
	 * @param primaryLastName
	 * @param secondLastName
	 * @return List<customer>
	 */
	public List<NttDataCustomer> searchByName(final String name, final String primaryLastName, final String secondLastName);
	
}
