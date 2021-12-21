package com.everis.hibernate.persistence;

import java.util.List;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */

public interface NttDataCustomerDaoI {

	/**
	 * Insertado de cliente
	 * 
	 * @param insertCustomer
	 * 
	 */
	public void insert(final NttDataCustomer insertCustomer);

	/**
	 * Actualizado de cliente
	 * 
	 * @param updateCustomer
	 * 
	 */
	public void update(final NttDataCustomer updateCustomer);

	/**
	 * Borrado de cliente
	 * 
	 * @param deleteCustomer
	 * 
	 */
	public void delete(final NttDataCustomer deleteCustomer);

	/**
	 * Búsqueda por ID
	 * 
	 * @param id
	 * 
	 * @return NttDataCustomer
	 */
	public NttDataCustomer searchById(final Long id);

	/**
	 * Return de todos los clientes disponibles
	 * 
	 * @return List<NttDatacustomer>
	 */
	public List<NttDataCustomer> searchAll();

	/**
	 * 
	 * Búsqueda de cliente por nombre y apellidos
	 * 
	 * @param name
	 * @param primaryLastName
	 * @param secondLastName
	 * @return List<NttDatacustomer>
	 */
	public List<NttDataCustomer> searchByNameAndSurname(final String name, final String firstSurname, final String secondSurname);
	
}
