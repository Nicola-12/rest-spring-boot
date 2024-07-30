package br.com.nicola.apigateway.utils;

/**
 *
 * @author ne
 */
public class Helper
{
	public static double convertToDouble(String strNumber )
	{
		if ( strNumber == null )
		{
			return 0D;
		}

		String number = strNumber.replaceAll( ",", "." );

		if ( isNumeric( number ) )
		{
			return Double.parseDouble( number );
		}

		return 0D;
	}

	public static boolean isNumeric( String number )
	{
		return number != null && number.matches( "[-+]?[0-9]*\\.?[0-9]+" );
	}
}
