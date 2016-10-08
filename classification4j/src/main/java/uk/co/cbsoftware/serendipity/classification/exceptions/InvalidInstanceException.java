package uk.co.cbsoftware.serendipity.classification.exceptions;

/**
 * InvalidInstanceException is thrown when an Instance provided by the user is
 * deemed to be invalid.
 * 
 * @author Connor Bray
 */
public class InvalidInstanceException extends Exception {

	private static final long serialVersionUID = -1690463683962521311L;

	public InvalidInstanceException(String msg) {
		super(msg);
	}
}
