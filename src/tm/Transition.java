package tm;

public class Transition {

    State oldState;
    TapeAlphabet symbolRead;

    State newState;
    TapeAlphabet symbolWrite;
    Direction direction;

    public Transition(int oldStateId, TapeAlphabet symbolRead, int newStateId, TapeAlphabet symbolWrite, Direction direction) {
        this.oldState = new State(oldStateId);
        this.symbolRead = symbolRead;
        this.newState = new State(newStateId);
        this.symbolWrite = symbolWrite;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return oldState.getId() + " " +
                symbolRead.id() + " " +
                newState.getId() + " " +
                symbolWrite.id() + " " +
                direction.id();
    }
}
