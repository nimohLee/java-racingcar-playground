package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @Test
    void 랜덤숫자0_9숫자생성() {
        RandomUtil randomUtil = new RandomUtil();
        int result = randomUtil.makeNumberZeroToNine();
        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
