package com.everis.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.everis.hibernate.persistence.NttDataCustomer;
import com.everis.services.NttDataCustomerManagementServiceI;
import com.everis.services.NttDataCustomerManagementServiceImpl;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */
public class NttDataHibernateMainT1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de la sesión
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de los Servicios
		final NttDataCustomerManagementServiceI clientService = new NttDataCustomerManagementServiceImpl(session);

		// Clientes establecidos
		final NttDataCustomer client1 = new NttDataCustomer();
		client1.setName("Gustavo");
		client1.setPrimaryLastName("Becker");
		client1.setSecondLastName("Sánchez");
		client1.setDni("49125343G");

		final NttDataCustomer client2 = new NttDataCustomer();
		client2.setName("Jon");
		client2.setPrimaryLastName("Upamecano");
		client2.setSecondLastName("Fernández");
		client2.setDni("23546634E");
		
		final NttDataCustomer client3 = new NttDataCustomer();
		client3.setName("Jairo");
		client3.setPrimaryLastName("Benítez");
		client3.setSecondLastName("Tellez");
		client3.setDni("34255634D");

		clientService.insertNewCustomer(client1);
		clientService.insertNewCustomer(client2);
		clientService.insertNewCustomer(client3);

		// Lista con los clientes
		List<NttDataCustomer> list = clientService.searchAll();
		System.out.println(list);

		// Búsqueda del cliente1 y modificación de datos
		List<NttDataCustomer> listUpdate = clientService.searchByName(client1.getName(), client1.getPrimaryLastName(),
				client1.getSecondLastName());
		NttDataCustomer clientUpdate = listUpdate.get(0);
		clientUpdate.setSecondLastName("Del Rey");
		clientUpdate.setDni("63842385E");
		clientService.updateCustomer(clientUpdate);
		System.out.println("Cliente con ID -> " + clientUpdate.getId() + " actualizado.");

		// Búsqueda del cliente3 y modificación de datos
		List<NttDataCustomer> listUpdate3 = clientService.searchByName(client3.getName(), client3.getPrimaryLastName(),
				client3.getSecondLastName());
		NttDataCustomer clientUpdate3 = listUpdate3.get(0);
		clientUpdate3.setSecondLastName("Vázquez");
		clientUpdate3.setDni("49128735Q");
		clientService.updateCustomer(clientUpdate3);
		System.out.println("Cliente con ID -> " + clientUpdate3.getId() + " actualizado.");
		
		// Mostrado de los cambios
		list = clientService.searchAll();
		System.out.println(list);

		// Búsqueda del cliente1 y su respectivo borrado
		List<NttDataCustomer> listDelete = clientService.searchByName("Gustavo", "Becker", "Del Rey");
		NttDataCustomer clientDelete = listDelete.get(0);
		System.out.println("Cliente borrado con ID -> " + clientDelete.getId());
		clientService.deleteCustomer(clientDelete);

		// Mostrado de los cambios
		list = clientService.searchAll();
		System.out.println(list);

		// Cerrado de sesión
		session.close();

	}

}
