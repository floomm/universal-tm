package tm;


import java.util.List;

public class TM {

    private Tape tape;

    public TM(List<TapeAlphabet> configuration) {
        this.tape = new Tape(configuration);
    }

    public Tape getTape() {
        return tape;
    }
}
