package br.com.nicola.apigateway.repositories;

import br.com.nicola.apigateway.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{
}
