package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Numbers;
import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumberCountException;

public class NumbersTest {
    
    @Test
    @DisplayName("구분자로 스페이스, 콤마 등이 들어오더라도 숫자만 추출하여 사용")
    void 구분자_제거_테스트() {
        Numbers pure = new Numbers("123");
        Numbers comma = new Numbers("1,2,3");
        Numbers space = new Numbers("1 2 3");

        assertThat(pure).isEqualTo(comma).isEqualTo(space);
    }

    @Test
    @DisplayName("숫자가 세자리가 아니면 Exception")
    void 세자리_테스트() {
        Numbers valid = new Numbers("123");
        assertThat(valid.toString()).hasSize(3);

        assertThatThrownBy(() -> {
            new Numbers("1234");
        }).isInstanceOf(InvalidNumberCountException.class);
    }

    @Test
    @DisplayName("숫자에 중복이 있으면 Exception")
    void 서로다른_숫자_테스트() {
        assertThatThrownBy(() -> {
            new Numbers("112");
        }).isInstanceOf(DuplicateNumberException.class);
    }
}
