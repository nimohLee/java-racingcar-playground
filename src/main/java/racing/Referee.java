package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public List<Car> rank(List<Car> carList) {
        int highestPosition = getHighestPosition(carList);

        return carList.stream()
                .filter(car -> car.hasPosition(highestPosition))
                .collect(Collectors.toList());
    }

    public int getHighestPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);
    }

}
