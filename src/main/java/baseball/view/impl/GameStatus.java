package baseball.view.impl;

import baseball.exception.InvalidGameStatusException;

public enum GameStatus {

    CONTINUE,
    FINISH;

    public static GameStatus from(String status) {
        if("1".equals(status)) {
            return CONTINUE;
        }

        if("2".equals(status)) {
            return FINISH;
        }

        throw new InvalidGameStatusException();
    }
    
}
