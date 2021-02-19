package by.gomel.library.exception;

public class TcpServerException extends RuntimeException {
    public TcpServerException() {
    }

    public TcpServerException(String message) {
        super(message);
    }

    public TcpServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TcpServerException(Throwable cause) {
        super(cause);
    }
}
