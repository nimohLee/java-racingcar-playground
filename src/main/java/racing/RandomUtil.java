package racing;

import java.util.Random;

public class RandomUtil {

    private Random random = new Random();

    public int makeNumberZeroToNine() {
        return random.nextInt(9) + 1;
    }
}
