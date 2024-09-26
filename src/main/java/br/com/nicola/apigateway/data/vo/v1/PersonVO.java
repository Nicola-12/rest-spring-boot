package br.com.nicola.apigateway.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author ne
 */
@Getter
@Setter
@JsonPropertyOrder( { "id", "first_name", "last_name", "address", "gender" } )
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO
	extends
		RepresentationModel<PersonVO>
	implements
		Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;

	@Mapping( "id" )
	@JsonProperty( "id" )
	private Long key;

	@JsonProperty( "first_name" )
	private String firstName;

	@JsonProperty( "last_name" )
	private String lastName;
	private String address;
	private String gender;

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

		return Objects.equals( key, person.key ) &&
				       Objects.equals( firstName, person.firstName ) &&
				       Objects.equals( lastName, person.lastName ) &&
				       Objects.equals( address, person.address ) &&
				       Objects.equals( gender, person.gender );
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( key, firstName, lastName, address, gender );
	}
}
