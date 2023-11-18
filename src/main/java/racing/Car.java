package racing;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        position = new Position();
    }

    public boolean nameIs(String name) {
        return this.name.equals(new Name(name));
    }

    public void play(int i) {
        if (i >= 4) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getPositionDash() {
        String result = "-";
        for (int i = 0; i < getPosition(); i++) {
            result += "-";
        }
        return result;
    }

    public String getName() {
        return name.toString();
    }

    public boolean hasPosition(int i) {
        return position.positionIs(i);
    }

    @Override
    public int compareTo(Car c) {
        if (this.position.getPosition() > c.position.getPosition()) {
            return -1;
        }
        if (this.position.getPosition() < c.position.getPosition()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car target = (Car) obj;
            if (target.nameIs(this.name.toString())) {
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.name.toString();
    }
}
