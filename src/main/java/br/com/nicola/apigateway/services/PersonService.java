package br.com.nicola.apigateway.services;


import br.com.nicola.apigateway.controllers.PersonController;
import br.com.nicola.apigateway.data.vo.v1.PersonVO;
import br.com.nicola.apigateway.exceptions.ResourceNotFoundException;
import br.com.nicola.apigateway.mapper.DozerMapper;
import br.com.nicola.apigateway.models.Person;
import br.com.nicola.apigateway.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author ne
 */
@Service
@AllArgsConstructor
public class PersonService
{
	private final Logger logger = Logger.getLogger( PersonService.class.getName() );
	private final PersonRepository personRepository;

	/**
	 * findAll
	 *
	 * @return List<Person>
	 */
	public List<PersonVO> findAll()
	{
		logger.info( "Finding all people!" );

		List<PersonVO> vos = DozerMapper.parseListObjects( personRepository.findAll(), PersonVO.class );

		vos.forEach( p -> p.add( linkTo( methodOn( PersonController.class ).findById( p.getKey() ) ).withSelfRel() ) );

		return vos;
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

		PersonVO vo = DozerMapper.parseObject( person, PersonVO.class );

		vo.add( linkTo( methodOn( PersonController.class ).findById( id ) ).withSelfRel() );

		return vo;
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

		PersonVO vo = DozerMapper.parseObject( personRepository.save( person ), PersonVO.class );

		vo.add( linkTo( methodOn( PersonController.class ).findById( vo.getKey() ) ).withSelfRel() );

		return vo;
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

		Person entity = personRepository.findById( personVO.getKey() ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		entity.setFirstName( personVO.getFirstName() );
		entity.setLastName( personVO.getLastName() );
		entity.setAddress( personVO.getAddress() );
		entity.setGender( personVO.getGender() );

		PersonVO vo = DozerMapper.parseObject( personRepository.save( entity ), PersonVO.class );

		vo.add( linkTo( methodOn( PersonController.class ).findById( vo.getKey() ) ).withSelfRel() );

		return vo;
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