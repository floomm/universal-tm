package tm;

import java.util.ArrayList;
import java.util.List;

import static tm.Direction.*;
import static tm.TapeAlphabet.*;

public class Configurator {

    private static final int TRANSITION_LENGTH = 5;

    List<Transition> transitions = new ArrayList<>();

    public String configure() {
        List<String> binaryTransitions = new ArrayList<>();
        String[] transitionParts;
        for (Transition t : transitions) {
            StringBuilder sb = new StringBuilder();
            transitionParts = t.toString().split(" ");
            for (int i = 0; i < TRANSITION_LENGTH; i++) {
                int count = Integer.parseInt(transitionParts[i]);
                sb.append(ZERO.toString().repeat(Math.max(0, count)));
                sb.append(ONE);
            }
            String binaryTransition = sb.toString();
            binaryTransitions.add(binaryTransition.substring(0, binaryTransition.length() - 1));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ONE);
        for (String t : binaryTransitions) {
            sb.append(t + ONE + ONE);
        }
        sb.append("" + ONE + BLANK);

        return sb.toString();
    }

    public void setUpMultiplication() {
        addTransition(1, BLANK, 1, BLANK, RIGHT);
        addTransition(1, ZERO, 1, ZERO, RIGHT);
        addTransition(1, ONE, 3, ONE, RIGHT);
        addTransition(3, ZERO, 3, ZERO, RIGHT);
        addTransition(3, BLANK, 4, ONE, LEFT);
        addTransition(4, ZERO, 4, ZERO, LEFT);
        addTransition(4, ONE, 5, ONE, RIGHT);
        addTransition(5, X, 5, X, RIGHT);
        addTransition(5, ONE, 2, BLANK, RIGHT); // to accepting state
        addTransition(5, ZERO, 6, X, LEFT);
        addTransition(6, X, 6, X, LEFT);
        addTransition(6, ONE, 7, ONE, LEFT);
        addTransition(7, Y, 7, Y, LEFT);
        addTransition(7, BLANK, 13, BLANK, RIGHT);
        addTransition(7, ZERO, 8, Y, RIGHT);
        addTransition(8, Y, 8, Y, RIGHT);
        addTransition(8, ONE, 9, ONE, RIGHT);
        addTransition(9, ZERO, 9, ZERO, RIGHT);
        addTransition(9, X, 9, X, RIGHT);
        addTransition(9, ONE, 10, ONE, RIGHT);
        addTransition(10, ZERO, 10, ZERO, RIGHT);
        addTransition(10, BLANK, 11, ZERO, LEFT);
        addTransition(11, ZERO, 11, ZERO, LEFT);
        addTransition(11, ONE, 12, ONE, LEFT);
        addTransition(12, ZERO, 12, ZERO, LEFT);
        addTransition(12, X, 12, X, LEFT);
        addTransition(12, ONE, 7, ONE, LEFT);
        addTransition(13, Y, 13, ZERO, RIGHT);
        addTransition(13, ONE, 5, ONE, RIGHT);
    }

    private void addTransition(int oldStateId, TapeAlphabet symbolRead, int newStateId, TapeAlphabet symbolWrite, Direction dir) {
        transitions.add(new Transition(oldStateId, symbolRead, newStateId, symbolWrite, dir));
    }

}

