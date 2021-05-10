package tm;

import java.util.ArrayList;
import java.util.List;

public class Tape {

    private final List<TapeAlphabet> tape;

    public Tape(List<TapeAlphabet> tape) {
        this.tape = tape;
    }

    public List<TapeAlphabet> getTape() {
        return tape;
    }

    public List<String> getTapeCutout(int head, int cutoutSize) {
        int halfSize = cutoutSize/2;

        List<String> tapeCutout = new ArrayList<>();
        for (int i = head-halfSize; i < head+halfSize; i++) {
            try {
                if (i == head) {
                    tapeCutout.add("<" + tape.get(i) + ">");
                    continue;
                }
                tapeCutout.add(tape.get(i).toString());
            } catch (IndexOutOfBoundsException e) {
                if (i == head) {
                    tapeCutout.add("<" + TapeAlphabet.BLANK + ">");
                    continue;
                }
                tapeCutout.add(TapeAlphabet.BLANK.toString());
            }
        }

        return tapeCutout;
    }

}
