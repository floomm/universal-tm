package tm;

import java.util.List;

public class Transition {

    private State oldState;
    private TapeAlphabet symbolRead;

    private State newState;
    private TapeAlphabet symbolWrite;
    private Direction direction;

    public Transition(State oldState, TapeAlphabet symbolRead, State newState, TapeAlphabet symbolWrite, Direction direction) {
        this.oldState = oldState;
        this.symbolRead = symbolRead;
        this.newState = newState;
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
