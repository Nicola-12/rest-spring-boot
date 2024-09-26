package br.com.nicola.apigateway.controllers;

import br.com.nicola.apigateway.data.vo.v1.BookVO;
import br.com.nicola.apigateway.data.vo.v1.PersonVO;
import br.com.nicola.apigateway.services.BookService;
import br.com.nicola.apigateway.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RestController
@AllArgsConstructor
@RequestMapping( value = "api/book/v1" )
@Tag( name = "Book Endpoint", description = "Description for book endpoint" )
public class BookController
{
	private final BookService service;

	@Operation( summary = "Find all books recorded" )
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
	public List<BookVO> findAll()
	{
		return service.findAll();
	}

	@Operation( summary = "Find a book by its ID" )
	@GetMapping( value = "/{id}",
	             produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
	public BookVO findById( @PathVariable( value = "id" ) Long id )
	{
		return service.findById( id );
	}

	@Operation( summary = "Create a new book" )
	@PostMapping( consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
	              produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
	public BookVO create( @RequestBody BookVO personVO )
	{
		return service.create( personVO );
	}

	@Operation( summary = "Update a book" )
	@PutMapping( consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
	             produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
	public BookVO update( @RequestBody BookVO personVO )
	{
		return service.update( personVO );
	}

	@Operation( summary = "Delete a book by its ID" )
	@DeleteMapping( value = "/{id}" )
	public ResponseEntity<?> delete( @PathVariable( value = "id" ) Long id )
	{
		service.delete( id );

		return ResponseEntity.noContent().build();
	}
}
