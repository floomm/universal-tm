package tm;

public class Transition {

    private State oldState;
    private TapeAlphabet symbolRead;

    private State newState;
    private TapeAlphabet symbolWrite;
    private Direction direction;

    public Transition(int oldStateId, TapeAlphabet symbolRead, int newStateId, TapeAlphabet symbolWrite, Direction direction) {
        this.oldState = new State(oldStateId);
        this.symbolRead = symbolRead;
        this.newState = new State(newStateId);
        this.symbolWrite = symbolWrite;
        this.direction = direction;
    }

    public State getOldState() {
        return oldState;
    }

    public TapeAlphabet getSymbolRead() {
        return symbolRead;
    }

    public State getNewState() {
        return newState;
    }

    public TapeAlphabet getSymbolWrite() {
        return symbolWrite;
    }

    public Direction getDirection() {
        return direction;
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
