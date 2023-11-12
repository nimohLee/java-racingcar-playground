package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void 덧셈테스트_쉼표구분() {
        int result = StringCaculator.calculate("1,2,3");
        int result2 = StringCaculator.calculate("10,20,30");
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(60);
    }

    @Test
    void 덧셈테스트_세미콜론구분() {
        int result = StringCaculator.calculate("1;2;3");
        int result2 = StringCaculator.calculate("10;20;30");
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(60);
    }

    @Test
    void 덧셈테스트_커스텀구분자() {
        int result = StringCaculator.calculate("//u\n1u2u3");
        int result2 = StringCaculator.calculate("//u\n10u20u30");
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(60);
    }

    @Test
    void 덧셈테스트_숫자하나만() {
        int result = StringCaculator.calculate("1");
        int result2 = StringCaculator.calculate("2");
        assertThat(result).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
    }

    @Test
    void 덧셈테스트_빈문자열이면0리턴() {
        int result = StringCaculator.calculate("");
        int result2 = StringCaculator.calculate(null);
        assertThat(result).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @Test
    void 덧셈테스트_음수면RuntimeException() {

        assertThatThrownBy(() -> {
            StringCaculator.calculate("-1,2,3");
        }).isInstanceOf(RuntimeException.class);


    }

    @Test
    void 덧셈테스트_커스텀구분자_형식잘못됐을때_throw() {
        assertThatThrownBy(() -> {
            int result = StringCaculator.calculate("\\/u\n1u2u3"); // '\\/'가 있음
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
