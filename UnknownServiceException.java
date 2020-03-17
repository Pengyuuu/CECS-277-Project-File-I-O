/**@authors Erina Lara, Eric Truong
 * Date: March 16, 2020
 * Program: Throws an exception if the service is unknown
 */

public class UnknownServiceException extends IllegalArgumentException{

    /** Default constructor */
    public UnknownServiceException() {
    }

    /**
     * Overloaded constructor
     * @param message   custom message when throwing exception
     */
    public UnknownServiceException(String message) {
        super(message);
    }

    /**
     *Message of unknown service exception
     * @return message to be printed if exception gets thrown
     */
    @Override
    public String toString() {
        return "Unknown service. It should be Conference, Dinner, or Lodging. ";
    }
}
