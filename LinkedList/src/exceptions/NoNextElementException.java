package exceptions;

public class NoNextElementException extends Exception
{

	public NoNextElementException( )
	{
		
	}

	public NoNextElementException( String message )
	{
		super( message );
	}

	public NoNextElementException( Throwable cause )
	{
		super( cause );
	}

	public NoNextElementException( String message, Throwable cause )
	{
		super( message, cause );

	}

	public NoNextElementException( String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace )
	{
		super( message, cause, enableSuppression, writableStackTrace );
	}

}
