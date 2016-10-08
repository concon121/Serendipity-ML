package uk.co.cbsoftware.serendipity.classification.exceptions;

/**
 * InvalidDataSetException is thrown when the data set provided by the user is
 * deemed to be invalid.
 * 
 * @author Connor Bray
 */
public class InvalidDataSetException extends Exception {

	private static final long serialVersionUID = 58318502733024037L;

	public InvalidDataSetException(String msg) {
		super(msg);
	}

}
