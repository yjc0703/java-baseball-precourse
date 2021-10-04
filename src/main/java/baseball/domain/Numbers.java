package baseball.domain;

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
}
