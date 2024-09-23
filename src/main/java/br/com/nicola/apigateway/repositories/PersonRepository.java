package br.com.nicola.apigateway.repositories;

import br.com.nicola.apigateway.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ne
 */
public interface PersonRepository extends JpaRepository<Person, Long>
{
}
