package racing;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            Name target = (Name) obj;
            if (target.name.equals(this.name)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
