package br.com.nicola.apigateway.mapper.custom;

import br.com.nicola.apigateway.data.vo.v2.PersonVOV2;
import br.com.nicola.apigateway.models.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 *
 * @author ne
 */
@Service
public class PersonMapper
{
	/**
	 * convertEntityToVO
	 *
	 * @param person Person
	 * @return PersonVOV2
	 */
	public PersonVOV2 convertEntityToVO( Person person )
	{
		PersonVOV2 vo = new PersonVOV2();
		vo.setId( person.getId() );
		vo.setFirstName( person.getFirstName() );
		vo.setLastName( person.getLastName() );
		vo.setAddress( person.getAddress() );
		vo.setGender( person.getGender() );
		vo.setBirthDay( LocalDate.now() );

		return vo;
	}

	/**
	 * convertEntityToVO
	 *
	 * @param entity PersonVOV2
	 * @return Person
	 */
	public Person convertVOToEntity( PersonVOV2 entity )
	{
		Person vo = new Person();
		vo.setId( entity.getId() );
		vo.setFirstName( entity.getFirstName() );
		vo.setLastName( entity.getLastName() );
		vo.setAddress( entity.getAddress() );
		vo.setGender( entity.getGender() );

		return vo;
	}
}
