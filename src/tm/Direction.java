package tm;

public enum Direction {

    LEFT (1, 'L'),
    RIGHT (2, 'R');

    private int id;
    private char direction;

    Direction(int id, char direction) {
        this.id = id;
        this.direction = direction;
    }

    public int id() {
        return id;
    }

}
