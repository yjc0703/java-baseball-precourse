package baseball.service;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;

public class GameService {

    public BaseballResult predict(Numbers numbers, Numbers numbers2) {
        return new BaseballResult(numbers, numbers2);
    }
}
