package baseball.exception;

public class InvalidGameStatusException extends BaseballException {

    public InvalidGameStatusException() {
        super("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    
}
