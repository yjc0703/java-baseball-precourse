package baseball.controller;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;
import baseball.service.GameService;
import baseball.view.View;
import baseball.view.impl.GameStatus;

public class GameController {

    private final View view;

    private final GameService service;

    public GameController(View view, GameService service) {
        this.view = view;
        this.service = service;
    }

    public GameStatus play() {
        final Numbers numbers = generateNumbers();
        BaseballResult result = null;

        do {
            result = service.predict(numbers, view.getNumbers());
            view.printResult(result);
        } while(result.isNotSolved());

        return view.confirmRestart();
    }

    private Numbers generateNumbers() {
        // TODO: Randoms 이용하여 숫자 생성
        return new Numbers("123");
    }

}
