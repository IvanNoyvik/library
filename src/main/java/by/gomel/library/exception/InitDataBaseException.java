package by.gomel.library.exception;

public class InitDataBaseException extends RuntimeException {
    public InitDataBaseException() {
    }

    public InitDataBaseException(String message) {
        super(message);
    }

    public InitDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitDataBaseException(Throwable cause) {
        super(cause);
    }
}
