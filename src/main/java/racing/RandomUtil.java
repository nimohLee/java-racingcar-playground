package racing;

import java.util.Random;

public class RandomUtil {

    Random random = new Random();

    public int makeNumberZeroToNine() {
        return random.nextInt(9) + 1;
    }
}
