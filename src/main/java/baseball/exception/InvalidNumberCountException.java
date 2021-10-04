package baseball.exception;

public class InvalidNumberCountException extends BaseballException {

    public InvalidNumberCountException() {
        super("숫자는 세자리입니다.");
    }
    
}
