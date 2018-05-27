package xoxo.exceptions;

/**
 * An exception that is thrown if the message size
 * is greater than 10Kbit.
 * 
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class SizeTooBigException extends RuntimeException {

    /**
     * Class constructor.
     */
    public SizeTooBigException(String message) {
        super(message);
    }
    
}