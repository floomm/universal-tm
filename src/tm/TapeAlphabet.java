package tm;

public enum TapeAlphabet {

    ZERO(1, '0'),
    ONE(2, '1'),
    BLANK(3, 'u'),
    X(4, 'X'),
    Y(5, 'Y');

    private int id;
    private char symbol;

    TapeAlphabet(int id, char symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public int id() {
        return id;
    }

    public char symbol() {
        return symbol;
    }
}
