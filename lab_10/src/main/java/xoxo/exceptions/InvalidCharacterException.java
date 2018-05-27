package xoxo.exceptions;

/**
 * An exception that is thrown if the Kiss Key that
 * is used to encrypt a message contains character
 * other than a-z, A-Z, @.
 *
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class InvalidCharacterException extends RuntimeException {

    /**
	 * Class constructor.
	 */
    public InvalidCharacterException(String message) {
    	super(message);
    }
}