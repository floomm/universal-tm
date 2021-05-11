package tm;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TM {

    private static final int TAPE_CUTOUT_SIZE = 31;

    private final Configurator configurator;
    private final Tape tapeList;
    private State currentState;
    private int head;
    private boolean halted = false;
    private int result = 0;
    private int stepCounter = 1;
    private boolean stepMode;

    public TM(Configurator configurator, boolean stepMode) {
        this.configurator = configurator;
        this.tapeList = new Tape(configurator.configure());
        for (State state : configurator.getStates()) {
            if (state.isInitialState()) {
                this.currentState = state;
                break;
            }
        }
        this.head = getTapeList().size()-1;
        this.stepMode = stepMode;
    }

    public List<TapeAlphabet> getTapeList() {
        return tapeList.getTapeList();
    }

    public int getResult() {
        return result;
    }

    /**
     * Runs until the accepting state is reached.
     */
    public void run() {
        printStep();

        while (!currentState.isAcceptingState()) {
            step();
            printStep();
        }
        halted = true;

        readResult();
    }

    /**
     * Performs a single step.
     */
    public void step() {
        if (halted) throw new RuntimeException("Cannot step halted machine");

        stepCounter++;

        Transition transition = determineTransition();

        if (transition == null) {
            throw new RuntimeException("No suitable transition found");
        }

        updateTape(transition);
    }

    // region private
    /**
     * @return The {@link Transition} that starts from the current state and has the corresponding reading symbol.
     */
    private Transition determineTransition() {
        List<Transition> transitionsOfCurrentState = configurator.getTransitionsOfAState(currentState);

        int idOfSymbolAtHead;
        try {
            idOfSymbolAtHead = getTapeList().get(head).id();
        } catch (IndexOutOfBoundsException e) {
            idOfSymbolAtHead = TapeAlphabet.BLANK.id();
        }

        for (Transition transition : transitionsOfCurrentState) {
            if (transition.getSymbolRead().id() == idOfSymbolAtHead) {
                return transition;
            }
        }

        return null;
    }

    /**
     * Updates the tapeList following the given transition
     * @param transition
     */
    private void updateTape(Transition transition) {
        try {
            getTapeList().set(head, transition.getSymbolWrite());
        } catch (IndexOutOfBoundsException e) {
            getTapeList().add(transition.getSymbolWrite());
        }
        currentState = transition.getNewState();
        head += transition.getDirection().value();
    }

    private void printStep() {
        System.out.printf("%s%n", currentState);
        System.out.printf("Berechnungs-Nr.: %d%n", stepCounter);
        System.out.printf("Kopfposition: %d%n", head+1);
        System.out.printf("%s%n", tapeList.getTapeCutout(head, TAPE_CUTOUT_SIZE));
        System.out.println();

        if (stepMode) {
            System.out.println("Enter drücken ('L' für Laufmodus)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.isBlank() && input.toLowerCase(Locale.ROOT).charAt(0) == 'l') {
                stepMode = false;
            }
        }
    }

    private void readResult() {
        int i = 1;
        while (getTapeList().get(getTapeList().size()-i) == TapeAlphabet.ZERO) {
            result++;
            i++;
        }
    }
    // endregion

}
