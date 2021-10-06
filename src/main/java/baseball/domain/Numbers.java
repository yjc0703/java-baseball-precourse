package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberCountException;

public class Numbers {
    
    private final String first;
    private final String second;
    private final String third;

    public Numbers(String input) {
        String numbers = input.replaceAll("\\D+","");
        String[] split = numbers.split("");
        if(split.length != 3) {
            throw new InvalidNumberCountException();
        }

        first = split[0];
        second = split[1];
        third = split[2];
        assertDifferent();
    }
    
    public int countStrike(Numbers target) {
        return calcStrikeCount(first, target.first) + 
            calcStrikeCount(second, target.second) + 
            calcStrikeCount(third, target.third);
    }

    public int countBall(Numbers target) {
        int ballcount = 0;
        List<String> thisList = Arrays.asList(first, second, third);
        List<String> targetList = Arrays.asList(target.first, target.second, target.third);
        for(int i = 0; i < thisList.size(); i++) {
            List<String> clone = new ArrayList<>(thisList);
            clone.remove(i);
            ballcount += calcBallCount(targetList.get(i), clone);
        }
        return ballcount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Numbers))
            return false;
        Numbers numbers = (Numbers)o;
        return Objects.equals(first, numbers.first) && 
            Objects.equals(second, numbers.second) &&
            Objects.equals(third, numbers.third);
    }

    @Override
    public String toString() {
        return first + second + third;
    }

    private void assertDifferent() {
        assertDifferent(first, second);
        assertDifferent(first, third);
        assertDifferent(second, third);
    }

    private void assertDifferent(String number1, String number2) {
        if(number1.equals(number2)) {
            throw new DuplicateNumberException();
        }
    }

    private int calcStrikeCount(String number1, String number2) {
        return number1.equals(number2) ? 1 : 0;
    }
    
    private int calcBallCount(String number, List<String> clone) {
        return clone.indexOf(number) >= 0 ? 1 : 0;
    }
}
