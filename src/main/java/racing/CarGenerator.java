package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    public List<Car> generate(String nameStr) {
        List<Car> carList = Arrays.stream(seperateNames(nameStr))
                .map(name -> {
                    return new Car(new Name(name));
                })
                .collect(Collectors.toList());

        return carList;
    }

    private String[] seperateNames(String names) {
        return names.split(",");
    }
}
