
public class BadDataException extends NumberFormatException {

    public BadDataException() {

    }

    public BadDataException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Data is not in correct format of: Name;Service;Amount;Date";
    }
}
