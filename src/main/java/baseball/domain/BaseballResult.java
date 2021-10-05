package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballResult {

    private final boolean isSameNumbers;

    private final int strikes;

    private final int balls;

    public BaseballResult(Numbers numbers, Numbers numbers2) {
        this.isSameNumbers = numbers.equals(numbers2);
        this.strikes = numbers.countStrike(numbers2);
        this.balls = numbers.countBall(numbers2);
    }

    public boolean isNotSolved() {
        return !isSameNumbers;
    }

    public String getResultString() {
        List<String> list = new ArrayList<>();
        addResultString(list, strikes, "스트라이크");
        addResultString(list, balls, "볼");
        if(list.size() > 0) {
            return String.join(" ", list);
        }
        return "낫싱";
    }

    private void addResultString(List<String> list, int count, String predictType) {
        if(count > 0) {
            list.add(count + predictType);
        }
    }

}
