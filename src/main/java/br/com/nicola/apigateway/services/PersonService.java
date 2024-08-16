package br.com.nicola.apigateway.services;


import br.com.nicola.apigateway.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 *
 * @author ne
 */
@Service
public class PersonService
{
	private final AtomicLong counter = new AtomicLong();
	private final Logger logger = Logger.getLogger( PersonService.class.getName() );

	/**
	 * findAll
	 *
	 * @return List<Person>
	 */
	public List<Person> findAll()
	{
		logger.info( "Finding all people!" );

		List<Person> persons = new ArrayList<>();

		for ( int i = 0; i < 8; i++ )
		{
			persons.add( mockPerson( i ) );
		}

		return persons;
	}



	/**
	 * findById
	 *
	 * @param id String
	 * @return Person
	 */
	public Person findById( String id )
	{
		logger.info( "Finding one person!" );

		Person person = new Person();
		person.setId( counter.incrementAndGet() );
		person.setFirstName( "Nicolas" );
		person.setLastName( "Endrizzi" );
		person.setAddress( "Lajeado, Rio Grande do Sul" );
		person.setGender( "Male" );

		return person;
	}

	/**
	 * create
	 *
	 * @param person Person
	 * @return Person
	 */
	public Person create( Person person )
	{
		logger.info( "Creating one person" );

		return person;
	}

	/**
	 * update
	 *
	 * @param person Person
	 * @return Person
	 */
	public Person update( Person person )
	{
		logger.info( "Updating one person" );

		return person;
	}

	/**
	 * delete
	 *
	 * @param id String
	 */
	public void delete( String id )
	{
		logger.info( "Deleting one person" );
	}


	/**
	 * mockPerson
	 *
	 * @param index int
	 * @return Person
	 */
	private Person mockPerson( int index )
	{
		Person person = new Person();
		person.setId( counter.incrementAndGet() );
		person.setFirstName( "First Name " + index );
		person.setLastName( "Last Name " + index );
		person.setAddress( "Address " + index );
		person.setGender( "Gender " + index );

		return person;
	}
}
