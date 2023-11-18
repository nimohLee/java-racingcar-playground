package racing;

public class Position {
    private int position;

    Position(){
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += 1;
    }

    public boolean positionIs(int i) {
        return position == i;
    }
}
