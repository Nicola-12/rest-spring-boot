package br.com.nicola.apigateway.data.vo.v1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author ne
 */
public class PersonVO
		implements
		Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;

	/**
	 * Person
	 */
	public PersonVO()
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

		PersonVO person = ( PersonVO ) o;

		return Objects.equals( id, person.id ) &&
				       Objects.equals( firstName, person.firstName ) &&
				       Objects.equals( lastName, person.lastName ) &&
				       Objects.equals( address, person.address ) &&
				       Objects.equals( gender, person.gender );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( id, firstName, lastName, address, gender );
	}
}
