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
    
    public int countStrike(Numbers numbers2) {
        return calcStrikeCount(first, numbers2.first) + 
            calcStrikeCount(second, numbers2.second) + 
            calcStrikeCount(third, numbers2.third);
    }

    public int countBall(Numbers numbers2) {
        int ballcount = 0;
        List<String> list = Arrays.asList(first, second, third);
        List<String> list2 = Arrays.asList(numbers2.first, numbers2.second, numbers2.third);
        for(int i = 0; i < list.size(); i++) {
            List<String> clone = new ArrayList<>(list);
            clone.remove(i);
            ballcount += calcBallCount(list2.get(i), clone);
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

    private int calcStrikeCount(String number, String number2) {
        return number.equals(number2) ? 1 : 0;
    }
    
    private int calcBallCount(String number, List<String> clone) {
        return clone.indexOf(number) >= 0 ? 1 : 0;
    }
}
