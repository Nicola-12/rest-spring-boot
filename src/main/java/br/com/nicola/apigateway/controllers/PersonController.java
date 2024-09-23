package br.com.nicola.apigateway.controllers;

import br.com.nicola.apigateway.data.vo.v1.PersonVO;
import br.com.nicola.apigateway.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ne
 */
@RestController
@AllArgsConstructor
@RequestMapping( value = "api/person/v1" )
public class PersonController
{
	private final PersonService service;

	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public List<PersonVO> findAll()
	{
		return service.findAll();
	}

	@GetMapping( value = "/{id}",
	             produces = MediaType.APPLICATION_JSON_VALUE )
	public PersonVO findById( @PathVariable( value = "id" ) Long id )
	{
		return service.findById( id );
	}

	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
	              produces = MediaType.APPLICATION_JSON_VALUE )
	public PersonVO create( @RequestBody PersonVO personVO )
	{
		return service.create( personVO );
	}

	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
	             produces = MediaType.APPLICATION_JSON_VALUE )
	public PersonVO update( @RequestBody PersonVO personVO )
	{
		return service.update( personVO );
	}

	@DeleteMapping( value = "/{id}" )
	public ResponseEntity<?> delete( @PathVariable( value = "id" ) Long id )
	{
		service.delete( id );

		return ResponseEntity.noContent().build();
	}
}
