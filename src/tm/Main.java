package tm;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import static tm.TapeAlphabet.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int[] numbers = new int[2];

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Configurator configurator = new Configurator();

        askForConfiguration(configurator);

        boolean stepMode = askForStepMode();

        TM tm = new TM(configurator, stepMode);

        putSymbolsOnTape(tm);

        System.out.printf("%nBand zu Beginn: %s%n%n", tm.getTapeList());

        tm.run();

        System.out.printf("-----%nResultat: %d%n-----%n", tm.getResult());

        scanner.close();
    }

    static void askForConfiguration(Configurator configurator) {
        Configuration configuration = null;

        System.out.println("Bitte eine Konfiguration auswählen: ");
        for (Configuration config : Configuration.values()) {
            System.out.println(config);
        }

        int id = scanner.nextInt();

        for (Configuration config : Configuration.values()) {
            if (id == config.getId()) configuration = config;
        }

        if (configuration == null) {
            throw new InputMismatchException("Unbekannte Konfiguration");
        }

        numbers = new int[2];

        switch (configuration) {
            case MULTIPLICATION -> {
                configurator.setUpMultiplication();
                numbers = multiply();
            }
            case ADDITION -> {
                configurator.setUpAddition();
                numbers = addition();
            }
            default -> System.err.println("Fehler: Unbekannte Konfiguration");
        }
    }

    static int[] multiply() {
        int[] numbers = new int[2];

        System.out.println("----- Multiplikation -----");
        System.out.print("Erste Zahl: ");
        numbers[0] = scanner.nextInt();
        System.out.print("Zweite Zahl: ");
        numbers[1]= scanner.nextInt();
        System.out.printf("Es wird kalkuliert: %d x %d%n", numbers[0], numbers[1]);

        return numbers;
    }

    static int[] addition() {
        int[] numbers = new int[2];

        System.out.println("----- Addition -----");
        System.out.print("Erste Zahl: ");
        numbers[0] = scanner.nextInt();
        System.out.print("Zweite Zahl: ");
        numbers[1]= scanner.nextInt();
        System.out.printf("Es wird kalkuliert: %d + %d%n", numbers[0], numbers[1]);

        return numbers;
    }

    static boolean askForStepMode() {
        boolean stepMode = false;

        System.out.print("Step-Modus (y/n): ");
        char input = scanner.next().toLowerCase(Locale.ROOT).charAt(0);

        if (input == 'y') stepMode = true;

        return stepMode;
    }

    static void putSymbolsOnTape(TM tm) {
        for (int num : numbers) {
            for (int i = 0; i < num; i++) {
                tm.getTapeList().add(ZERO);
            }
            tm.getTapeList().add(ONE);
        }
    }

}
