package br.com.nicola.apigateway.exceptions.handlers;

import br.com.nicola.apigateway.exceptions.ExceptionResponse;
import br.com.nicola.apigateway.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author ne
 */
@ControllerAdvice
@RestController
public class CustomizedExceptionHandler
	extends
		ResponseEntityExceptionHandler
{

	@ExceptionHandler( Exception.class )
	public final ResponseEntity<ExceptionResponse> handleAllExceptions( Exception ex, WebRequest request )
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse( ex.getMessage(), request.getDescription( false ), java.time.LocalDate.now() );

		return new ResponseEntity<>( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR );
	}

	@ExceptionHandler( ResourceNotFoundException.class )
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions( Exception ex, WebRequest request )
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse( ex.getMessage(), request.getDescription( false ), java.time.LocalDate.now() );

		return new ResponseEntity<>( exceptionResponse, HttpStatus.NOT_FOUND );
	}
}
