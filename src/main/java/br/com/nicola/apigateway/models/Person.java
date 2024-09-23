package br.com.nicola.apigateway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ne
 */
@Entity
@Table( name = "person")
public class Person
		implements
		Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( name = "first_name", nullable = false, length = 180 )
	private String firstName;

	@Column( name = "last_name", nullable = false, length = 180 )
	private String lastName;

	@Column( nullable = false, length = 100 )
	private String address;

	@Column( nullable = false, length = 6 )
	private String gender;

	/**
	 * Person
	 */
	public Person()
	{
	}

	/**
	 * getId
	 *
	 * @return Long
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * setId
	 *
	 * @param id Long
	 */
	public void setId( Long id )
	{
		this.id = id;
	}

	/**
	 * getFirstName
	 *
	 * @return String
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * setFirstName
	 *
	 * @param firstName String
	 */
	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	/**
	 * getLastName
	 *
	 * @return String
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * setLastName
	 *
	 * @param lastName String
	 */
	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	/**
	 * getAddress
	 *
	 * @return String
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * setAddress
	 *
	 * @param address String
	 */
	public void setAddress( String address )
	{
		this.address = address;
	}

	/**
	 * getGender
	 *
	 * @return String
	 */
	public String getGender()
	{
		return gender;
	}

	/**
	 * setGender
	 *
	 * @param gender String
	 */
	public void setGender( String gender )
	{
		this.gender = gender;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
		{
			return true;
		}
		if ( o == null || getClass() != o.getClass() )
		{
			return false;
		}

		Person personVO = ( Person ) o;

		return Objects.equals( id, personVO.id ) &&
				       Objects.equals( firstName, personVO.firstName ) &&
				       Objects.equals( lastName, personVO.lastName ) &&
				       Objects.equals( address, personVO.address ) &&
				       Objects.equals( gender, personVO.gender );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( id, firstName, lastName, address, gender );
	}
}
