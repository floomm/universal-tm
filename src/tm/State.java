package tm;


public class State {

    private static final int ID_INITIAL_STATE = 1;
    private static final int ID_ACCEPTING_STATE = 2;

    private int id;
    private boolean isInitialState;
    private boolean isAcceptingState;

    public State(int id) {
        this.id = id;
        isInitialState = (id == ID_INITIAL_STATE);
        isAcceptingState = (id == ID_ACCEPTING_STATE);
    }

    public int getId() {
        return id;
    }
}
