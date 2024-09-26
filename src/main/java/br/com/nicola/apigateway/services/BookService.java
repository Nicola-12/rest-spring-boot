package br.com.nicola.apigateway.services;

import br.com.nicola.apigateway.controllers.BookController;
import br.com.nicola.apigateway.data.vo.v1.BookVO;
import br.com.nicola.apigateway.exceptions.ResourceNotFoundException;
import br.com.nicola.apigateway.mapper.DozerMapper;
import br.com.nicola.apigateway.models.Book;
import br.com.nicola.apigateway.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class BookService
{
	private final Logger logger = Logger.getLogger( PersonService.class.getName() );
	private final BookRepository bookRepository;

	public List<BookVO> findAll()
	{
		logger.info( "Finding all books!" );

		List<BookVO> vos = DozerMapper.parseListObjects( bookRepository.findAll(), BookVO.class );

		vos.forEach( p -> p.add( linkTo( methodOn( BookController.class ).findById( p.getKey() ) ).withSelfRel() ) );

		return vos;
	}


	public BookVO findById( Long id )
	{
		logger.info( "Finding one book!" );

		Book book = bookRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		BookVO vo = DozerMapper.parseObject( book, BookVO.class );

		vo.add( linkTo( methodOn( BookController.class ).findById( id ) ).withSelfRel() );

		return vo;
	}

	public BookVO create( BookVO BookVO )
	{
		logger.info( "Creating one person" );

		Book person = DozerMapper.parseObject( BookVO, Book.class );

		BookVO vo = DozerMapper.parseObject( bookRepository.save( person ), BookVO.class );

		vo.add( linkTo( methodOn( BookController.class ).findById( vo.getKey() ) ).withSelfRel() );

		return vo;
	}

	public BookVO update( BookVO bookVO )
	{
		logger.info( "Updating one book" );

		Book entity = bookRepository.findById( bookVO.getKey() ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		entity.setTitle( bookVO.getTitle() );
		entity.setAuthor( bookVO.getAuthor() );
		entity.setPrice( bookVO.getPrice() );
		entity.setLaunchDate( bookVO.getLaunchDate() );

		BookVO vo = DozerMapper.parseObject( bookRepository.save( entity ), BookVO.class );

		vo.add( linkTo( methodOn( BookController.class ).findById( vo.getKey() ) ).withSelfRel() );

		return vo;
	}

	public void delete( Long id )
	{
		logger.info( "Deleting one book" );

		Book entity = bookRepository.findById( id ).orElseThrow( () -> new ResourceNotFoundException( "No records found for this ID!" ) );

		bookRepository.delete( entity );
	}
}
