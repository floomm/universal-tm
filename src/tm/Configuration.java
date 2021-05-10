package tm;

public enum Configuration {

    MULTIPLICATION(1, "Multiplikation");

    private final int id;
    private final String name;

    Configuration(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
