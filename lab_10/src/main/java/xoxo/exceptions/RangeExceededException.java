package xoxo.exceptions;

/**
 * An exception that is thrown if the Seed that
 * is used to decrypt a message is lower than 0
 * or greater than 36.
 * 
 * @author Bunga Amalia Kurniawati, NPM 1706022104, Kelas D, GitLab Account: https://gitlab.com/bungamaku
 */

public class RangeExceededException extends RuntimeException {

    /**
     * Class constructor.
     */
    public RangeExceededException(String message) {
        super(message);
    }
    
}