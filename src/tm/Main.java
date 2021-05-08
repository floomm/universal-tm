package tm;

import java.util.InputMismatchException;
import java.util.Scanner;

import static tm.TapeAlphabet.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Configuration configuration = null;
        Configurator configurator = new Configurator();

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

        int[] numbers = new int[2];

        switch (configuration) {
            case MULTIPLICATION:
                configurator.setUpMultiplication();
                numbers = multiply();
                break;
            default:
                System.err.println("Fehler: Unbekannte Konfiguration");
        }

        TM tm = new TM(configurator.configure());

        for (int num : numbers) {
            for (int i = 0; i < num; i++) {
                tm.getTape().getTape().add(ZERO);
            }
            tm.getTape().getTape().add(ONE);
        }

        System.out.println(tm.getTape().getTape());

        scanner.close();

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

}
