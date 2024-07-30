package br.com.nicola.apigateway.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ne
 */
public class ExceptionResponse
	implements
		Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;

	private final String message;
	private final String details;
	private final LocalDate timestamp;

	public ExceptionResponse( String message, String details, LocalDate timestamp )
	{
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getMessage()
	{
		return message;
	}

	public String getDetails()
	{
		return details;
	}

	public LocalDate getTimestamp()
	{
		return timestamp;
	}
}
