package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void Name클래스이름비교() {
        Name name = new Name("blade");
        assertThat(name.equals("blade"));
    }

    @Test
    void Position클래스_위치더하기() {
        Position position = new Position();
        position.move();
        assertThat(position.positionIs(1)).isTrue();
        position.move();
        assertThat(position.positionIs(2)).isTrue();
    }

    @Test
    void 포장된이름을매개변수로하는자동차생성자() {
        Car blade = new Car(new Name("blade"));
        Car korea = new Car(new Name("korea"));
        assertThat(blade.nameIs("blade")).isTrue();
        assertThat(korea.nameIs("blade")).isFalse();
    }

    @Test
    void 숫자가4이상이면위치1더하는하는자동차() {
        Car blade = new Car(new Name("blade"));
        blade.play(3);
        assertThat(blade.hasPosition(1)).isFalse();
        blade.play(4);
        assertThat(blade.hasPosition(1)).isTrue();
    }

    @Test
    void position만큼dash출력(){
        Car blade = new Car(new Name("blade"));
        blade.play(5);
        blade.play(5);
        blade.play(5);
        assertThat(blade.getPositionDash()).isEqualTo("----");
    }
}
