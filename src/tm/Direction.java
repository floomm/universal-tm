package tm;

public enum Direction {

    LEFT (1, -1),
    RIGHT (2, 1);

    private final int id;
    private final int value;

    Direction(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int id() {
        return id;
    }

    public int value() {
        return value;
    }
}
