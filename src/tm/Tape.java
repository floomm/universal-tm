package tm;

import java.util.ArrayList;
import java.util.List;

public class Tape {

    private List<TapeAlphabet> tape = new ArrayList<>();

    public Tape(List<TapeAlphabet> tape) {
        this.tape = tape;
    }

    public List<TapeAlphabet> getTape() {
        return tape;
    }
}
