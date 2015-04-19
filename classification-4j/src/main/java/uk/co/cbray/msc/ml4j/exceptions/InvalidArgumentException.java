package uk.co.cbray.msc.ml4j.exceptions;

public class InvalidArgumentException extends Exception{

	private static final long serialVersionUID = 1406373774586600148L;
	
	private static final String expectedPlaceholder = "${expected}";
	private static final String wasPlaceholder = "${was}";
	
	private static final String msg = "Invalid argument.  Expected: " + expectedPlaceholder + " but was: " + wasPlaceholder;
	
	public InvalidArgumentException(Class<?> expected, Class<?> was) {
		
		super(msg.replace(expectedPlaceholder, expected.getName()).replace(wasPlaceholder, was.getName()));
		
	}
	
}
