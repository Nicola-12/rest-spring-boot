package br.com.nicola.apigateway.controllers;

import br.com.nicola.apigateway.exceptions.UnsupportedMathOperationException;
import br.com.nicola.apigateway.utils.Helper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ne
 */
@RestController
@RequestMapping( value = "/math" )
public class MathController
{
	@RequestMapping( value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double sum( @PathVariable( "numberOne" ) String numberOne,
                       @PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return Helper.convertToDouble( numberOne ) + Helper.convertToDouble( numberTwo );
	}

	@RequestMapping( value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double sub( @PathVariable( "numberOne" ) String numberOne,
					   @PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return Helper.convertToDouble( numberOne ) - Helper.convertToDouble( numberTwo );
	}

	@RequestMapping( value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double multiply( @PathVariable( "numberOne" ) String numberOne,
							@PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return Helper.convertToDouble( numberOne ) * Helper.convertToDouble( numberTwo );
	}

	@RequestMapping( value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double divide( @PathVariable( "numberOne" ) String numberOne,
						  @PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return Helper.convertToDouble( numberOne ) / Helper.convertToDouble( numberTwo );
	}

	@RequestMapping( value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double mean( @PathVariable( "numberOne" ) String numberOne,
						@PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return ( Helper.convertToDouble( numberOne ) + Helper.convertToDouble( numberTwo ) ) / 2;
	}

	@RequestMapping( value = "/square/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double squareRoot( @PathVariable( "numberOne" ) String numberOne,
	                          @PathVariable( "numberTwo" ) String numberTwo )
	{
		validateNumbers( numberOne, numberTwo );

		return Math.sqrt( Helper.convertToDouble( numberOne ) + Helper.convertToDouble( numberOne ) );
	}

	/**
	 * validateNumbers
	 *
	 * @param numberOne String
	 * @param numberTwo String
	 */
	private void validateNumbers( String numberOne, String numberTwo )
	{
		if ( !Helper.isNumeric( numberOne ) || !Helper.isNumeric( numberTwo ) )
		{
			throw new UnsupportedMathOperationException( "Please set a numeric value!" );
		}
	}
}
