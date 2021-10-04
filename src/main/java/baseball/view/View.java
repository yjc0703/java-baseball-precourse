package baseball.view;

import baseball.domain.Numbers;
import baseball.view.impl.GameStatus;

public interface View {

    Numbers getNumbers();
    void writeResult();
    GameStatus confirmRestart();
    
}
