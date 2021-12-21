package com.everis.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller1 de Hibernate - Formación NTTData
 * 
 * @author dvazqumu
 *
 */

@Entity
@Table(name = "NTTDATA_CUSTOMER")
public class NttDataCustomer implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long id;

	/** Nombre de cliente */
	private String name;

	/** Primer apellido */
	private String primaryLastName;

	/** Segundo apellido */
	private String secondLastName;

	/** DNI de cliente */
	private String dni;

	/**
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param setId
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return primaryLastName
	 */
	@Column(name = "PRIMARY_LASTNAME", nullable = false)
	public String getPrimaryLastName() {
		return primaryLastName;
	}

	/**
	 * @param setPrimaryLastName
	 */
	public void setPrimaryLastName(String primaryLastName) {
		this.primaryLastName = primaryLastName;
	}

	/**
	 * @return secondLastName
	 */
	@Column(name = "SECOND_LASTNAME", nullable = false)
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * @param SetSecondLastName
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * @return DNI
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param setDNI
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "NttDataCustomer -> Nombre: " + name + ", Primer apellido: " + primaryLastName + ", Segundo apellido: " + secondLastName + ", DNI: " + dni;
	}

	@Transient
	public Class<?> getClase() {
		return NttDataCustomer.class;
	}
	
}
