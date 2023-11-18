package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    void 가장높은포지션가져오기() {
        Referee referee = new Referee();
        Car blade = new Car(new Name("blade"));
        // 가장 높은 포지션 2
        blade.play(5);
        blade.play(5);
        Car top = new Car(new Name("top"));
        Car max = new Car(new Name("max"));
        List<Car> carList = Arrays.asList(blade, top, max);
        max.play(6);

        assertThat(referee.getHighestPosition(carList)).isEqualTo(2);
    }

    @Test
    void 우승이하나일때() {
        Referee referee = new Referee();
        Car blade = new Car(new Name("blade"));
        blade.play(5);
        blade.play(5);
        Car top = new Car(new Name("top"));
        Car max = new Car(new Name("max"));
        max.play(6);

        List<Car> carList = Arrays.asList(blade, top, max);
        List<Car> winners = referee.rank(carList);
        System.out.println(winners);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).nameIs("blade")).isTrue();

    }

    @Test
    void 우승이둘이상일때() {
        Referee referee = new Referee();
        Car blade = new Car(new Name("blade"));
        blade.play(5);
        Car top = new Car(new Name("top"));
        Car max = new Car(new Name("max"));
        max.play(6);

        List<Car> carList = Arrays.asList(blade, top, max);
        List<Car> winners = referee.rank(carList);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.contains(blade)).isTrue();
        assertThat(winners.contains(max)).isTrue();
    }
}
