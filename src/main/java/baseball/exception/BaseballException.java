package baseball.exception;

public class BaseballException extends RuntimeException {
    
    public BaseballException(String message) {
        super(String.format("[ERROR] %s", message));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}