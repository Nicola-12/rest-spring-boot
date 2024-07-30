package br.com.nicola.apigateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 *
 * @author ne
 */
@ResponseStatus( HttpStatus.BAD_REQUEST )
public class UnsupportedMathOperationException
	extends
		RuntimeException
{
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * UnsupportedMathOperationException
	 *
	 * @param message String
	 */
	public UnsupportedMathOperationException( String message )
	{
		super( message);
	}
}
