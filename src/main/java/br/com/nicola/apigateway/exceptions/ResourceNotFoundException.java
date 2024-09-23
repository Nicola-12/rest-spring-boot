package br.com.nicola.apigateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 *
 * @author ne
 */
@ResponseStatus( HttpStatus.NOT_FOUND )
public class ResourceNotFoundException
	extends
		RuntimeException
{
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * ResourceNotFoundException
	 *
	 * @param message String
	 */
	public ResourceNotFoundException( String message )
	{
		super( message );
	}
}
