package br.com.nicola.apigateway.mapper.custom;

import br.com.nicola.apigateway.data.vo.v1.BookVO;
import br.com.nicola.apigateway.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper
{
	public BookVO convertEntityToVO( Book book )
	{
		BookVO vo = new BookVO();
		vo.setKey( book.getId() );
		vo.setAuthor( book.getAuthor() );
		vo.setTitle( book.getTitle() );
		vo.setPrice( book.getPrice() );
		vo.setLaunchDate( book.getLaunchDate() );

		return vo;
	}

	public Book convertVOToEntity( BookVO entity )
	{
		Book vo = new Book();
		vo.setId( entity.getKey() );
		vo.setTitle( entity.getTitle() );
		vo.setAuthor( entity.getAuthor() );
		vo.setPrice( entity.getPrice() );
		vo.setLaunchDate( entity.getLaunchDate() );

		return vo;
	}
}
