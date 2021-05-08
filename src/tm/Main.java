package tm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration configuration = null;
        Configurator configurator = new Configurator();

        System.out.println("Bitte eine Konfiguration auswählen: ");
        for (Configuration config : Configuration.values()) {
            System.out.println(config);
        }

        int id = scanner.nextInt();
        scanner.close();

        for (Configuration config : Configuration.values()) {
            if (id == config.getId()) configuration = config;
        }

        if (configuration == null) {
            throw new InputMismatchException("Unbekannte Konfiguration");
        }

        switch (configuration) {
            case MULTIPLICATION -> configurator.setUpMultiplication();
        }

        TM tm = new TM(configurator.configure());

    }

}
