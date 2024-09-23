package br.com.nicola.apigateway.services;


import br.com.nicola.apigateway.data.vo.v1.PersonVO;
import br.com.nicola.apigateway.data.vo.v2.PersonVOV2;
import br.com.nicola.apigateway.exceptions.ResourceNotFoundException;
import br.com.nicola.apigateway.mapper.DozerMapper;
import br.com.nicola.apigateway.mapper.custom.PersonMapper;
import br.com.nicola.apigateway.models.Person;
import br.com.nicola.apigateway.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author ne
 */
@Service
public class PersonService
{
	private final Logger logger = Logger.getLogger( PersonService.class.getName() );

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonMapper personMapper;

	/**
	 * findAll
	 *
	 * @return List<Person>
	 */
	public List<PersonVO> findAll()
	{
		logger.info( "Finding all people!" );

		return DozerMapper.parseListObjects( personRepository.findAll(), PersonVO.class );
	}


	/**
	 * findById
	 *
	 * @param id Long
	 * @return Person
	 */
	public PersonVO findById( Long id )
	{
		logger.info( "Finding one person!" );

		Person person = personRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		return DozerMapper.parseObject( person, PersonVO.class );
	}

	/**
	 * create
	 *
	 * @param personVO Person
	 * @return Person
	 */
	public PersonVO create( PersonVO personVO )
	{
		logger.info( "Creating one person" );

		Person person = DozerMapper.parseObject( personVO, Person.class );

		return DozerMapper.parseObject( personRepository.save( person ), PersonVO.class );
	}

	/**
	 * createV2
	 *
	 * @param personVO PersonVOV2
	 * @return PersonVOV2
	 */
	public PersonVOV2 createV2( PersonVOV2 personVO )
	{
		logger.info( "Creating one person with V2!" );

		Person person = personMapper.convertVOToEntity( personVO );

		return personMapper.convertEntityToVO( personRepository.save( person ) );
	}

	/**
	 * update
	 *
	 * @param personVO Person
	 * @return Person
	 */
	public PersonVO update( PersonVO personVO )
	{
		logger.info( "Updating one person" );

		Person entity = personRepository.findById( personVO.getId() ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		entity.setFirstName( personVO.getFirstName() );
		entity.setLastName( personVO.getLastName() );
		entity.setAddress( personVO.getAddress() );
		entity.setGender( personVO.getGender() );

		return DozerMapper.parseObject( personRepository.save( entity ), PersonVO.class );
	}

	/**
	 * delete
	 *
	 * @param id Long
	 */
	public void delete( Long id )
	{
		logger.info( "Deleting one person" );

		Person entity = personRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		personRepository.delete( entity );
	}
}