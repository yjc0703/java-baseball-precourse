package baseball.exception;

public class DuplicateNumberException extends BaseballException {

    public DuplicateNumberException() {
        super("서로 다른 숫자 세자리를 입력해주세요.");
    }
    
}
