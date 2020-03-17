/**@authors Erina Lara, Eric Truong
 * Date: March 3, 2020
 * Program: Throws an error if the format is not correct
 */

public class BadDataException extends NumberFormatException {

    /** Default constructor for exception */
    public BadDataException() {

    }

    /** Constructor with custom message */
    public BadDataException(String message) {
        super(message);
    }

    /**
     * Message to be printed if exception is thrown
     * @return message to be printed
     */
    @Override
    public String toString() {
        return "Data is not in correct format of: Name;Service;Amount;Date";
    }
}
