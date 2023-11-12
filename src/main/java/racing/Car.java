package racing;

public class Car {

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

    public boolean hasPosition(int i) {
        return position.positionIs(i);
    }
}
