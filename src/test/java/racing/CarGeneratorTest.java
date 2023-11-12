package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGeneratorTest {

    @Test
    void 문자열로_자동차리스트하나생성() {
        String names = "blade";
        CarGenerator carGenerator = new CarGenerator();
        List<Car> carList = carGenerator.generate(names);
        assertThat(carList.size()).isEqualTo(1);
        Car car = carList.get(0);

        assertThat(car.nameIs("blade")).isTrue();
    }

    @Test
    void 문자열로_자동차리스트여러개생성() {
        String names = "blade,top,max";
        CarGenerator carGenerator = new CarGenerator();
        List<Car> carList = carGenerator.generate(names);
        assertThat(carList.size()).isEqualTo(3);
        Car blade = carList.get(0);
        Car top = carList.get(1);
        Car max = carList.get(2);

        assertThat(blade.nameIs("blade")).isTrue();
        assertThat(top.nameIs("top")).isTrue();
        assertThat(max.nameIs("max")).isTrue();
    }
}
