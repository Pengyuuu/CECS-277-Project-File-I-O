public class UnknownServiceException extends IllegalArgumentException{

    public UnknownServiceException() {
    }

    public UnknownServiceException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Unknown service. It should be Conference, Dinner, or Lodging. ";
    }
}
