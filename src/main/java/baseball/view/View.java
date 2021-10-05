package baseball.view;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;
import baseball.view.impl.GameStatus;

public interface View {
    Numbers getNumbers();
    GameStatus confirmRestart();
    void printResult(BaseballResult result);
    void printFinish();
}
