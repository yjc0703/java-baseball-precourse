package baseball.service;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;

public class GameService {

    public BaseballResult predict(Numbers gameNumbers, Numbers userNumbers) {
        return new BaseballResult(gameNumbers, userNumbers);
    }
}
