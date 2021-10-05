package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;
import baseball.service.GameService;
import baseball.view.View;
import baseball.view.impl.GameStatus;
import nextstep.utils.Randoms;

public class GameController {

    private final View view;

    private final GameService service;

    public GameController(View view, GameService service) {
        this.view = view;
        this.service = service;
    }

    public GameStatus play() {
        final Numbers numbers = generateNumbers();
        System.out.println(numbers);
        BaseballResult result = null;

        do {
            result = service.predict(numbers, view.getNumbers());
            view.printResult(result);
        } while(result.isNotSolved());

        return view.confirmRestart();
    }

    private Numbers generateNumbers() {
        List<String> list = new ArrayList<>(3);
        while(list.size() < 3) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(list.indexOf(number) < 0) {
                list.add(number);
            }
        }
        return new Numbers(String.join("", list));
    }

}
