package br.com.nicola.apigateway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author ne
 */
@Getter
@Setter
@Entity
@Table( name = "person" )
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
