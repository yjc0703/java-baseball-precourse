package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;

public class BaseballResultTest {
    
    @Test
    @DisplayName("스트라이크만 있는 경우 테스트")
    void 스트라이크_볼_테스트() {
        BaseballResult strike1 = new BaseballResult(new Numbers("123"), new Numbers("145"));
        assertThat(strike1.getResultString()).isEqualTo("1스트라이크");
        assertThat(strike1.isNotSolved()).isEqualTo(true);

        BaseballResult strike2 = new BaseballResult(new Numbers("123"), new Numbers("143"));
        assertThat(strike2.getResultString()).isEqualTo("2스트라이크");
        assertThat(strike2.isNotSolved()).isEqualTo(true);


        BaseballResult strike3 = new BaseballResult(new Numbers("123"), new Numbers("123"));
        assertThat(strike3.getResultString()).isEqualTo("3스트라이크");
        assertThat(strike3.isNotSolved()).isEqualTo(false);

        BaseballResult strike1ball1 = new BaseballResult(new Numbers("123"), new Numbers("134"));
        assertThat(strike1ball1.getResultString()).isEqualTo("1스트라이크 1볼");
        assertThat(strike1ball1.isNotSolved()).isEqualTo(true);

        BaseballResult strike1ball2 = new BaseballResult(new Numbers("123"), new Numbers("132"));
        assertThat(strike1ball2.getResultString()).isEqualTo("1스트라이크 2볼");
        assertThat(strike1ball2.isNotSolved()).isEqualTo(true);
    }

}
