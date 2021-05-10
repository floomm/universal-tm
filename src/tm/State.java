package tm;


import java.util.Objects;

public class State {

    public static final int ID_INITIAL_STATE = 1;
    public static final int ID_ACCEPTING_STATE = 2;

    private final int id;
    private final boolean isInitialState;
    private final boolean isAcceptingState;

    public State(int id) {
        this.id = id;
        isInitialState = (id == ID_INITIAL_STATE);
        isAcceptingState = (id == ID_ACCEPTING_STATE);
    }

    public int getId() {
        return id;
    }

    public boolean isInitialState() {
        return isInitialState;
    }

    public boolean isAcceptingState() {
        return isAcceptingState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Zustand: q" + id);
        if (isInitialState) sb.append(" (initial state)");
        if (isAcceptingState) sb.append(" (accepting state)");

        return sb.toString();
    }
}
