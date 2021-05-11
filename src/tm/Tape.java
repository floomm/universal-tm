package tm;

import java.util.ArrayList;
import java.util.List;

public class Tape {

    private final List<TapeAlphabet> tapeList;

    public Tape(List<TapeAlphabet> tapeList) {
        this.tapeList = tapeList;
    }

    public List<TapeAlphabet> getTapeList() {
        return tapeList;
    }

    public List<String> getTapeCutout(int head, int cutoutSize) {
        int halfSize = cutoutSize/2;

        List<String> tapeCutout = new ArrayList<>();
        for (int i = head-halfSize; i < head+halfSize; i++) {
            try {
                if (i == head) {
                    tapeCutout.add("<" + tapeList.get(i) + ">");
                    continue;
                }
                tapeCutout.add(tapeList.get(i).toString());
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
