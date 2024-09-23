package br.com.nicola.apigateway.data.vo.v2;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author ne
 */
public class PersonVOV2
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

	private LocalDate birthDay;

	/**
	 * Person
	 */
	public PersonVOV2()
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

	/**
	 * getBirthDay
	 *
	 * @return LocalDate
	 */
	public LocalDate getBirthDay()
	{
		return birthDay;
	}

	/**
	 * setBirthDay
	 *
	 * @param birthDay LocalDate
	 */
	public void setBirthDay( LocalDate birthDay )
	{
		this.birthDay = birthDay;
	}

	/**
	 * equals
	 *
	 * @param o Object
	 * @return boolean
	 */
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
		PersonVOV2 that = ( PersonVOV2 ) o;
		return Objects.equals( id, that.id ) && Objects.equals( firstName, that.firstName ) && Objects.equals( lastName, that.lastName ) && Objects.equals( address, that.address ) && Objects.equals( gender, that.gender ) && Objects.equals( birthDay, that.birthDay );
	}

	/**
	 * hashCode
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash( id, firstName, lastName, address, gender, birthDay );
	}
}
