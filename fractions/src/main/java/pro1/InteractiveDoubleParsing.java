package pro1;

import java.util.Scanner;

public class InteractiveDoubleParsing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nekonečná smyčka pro opakování zadávání čísel
        while (true) {
            System.out.print("Zadejte číslo: ");
            String vstup = scanner.nextLine().trim();  // Odstraníme případné mezery

            // Pokud je vstup prázdný, přeskočíme cyklus
            if (vstup.isEmpty()) {
                System.out.println("Zadal jste prázdný vstup. Zkuste to znovu.");
                continue;
            }

            // Pokud je vstup platné číslo (kontrola pomocí regulárního výrazu)
            if (vstup.matches("-?\\d*(\\.\\d+)?")) {
                double number = Double.parseDouble(vstup);
                System.out.println("Zadal jste číslo: " + number);
            } else {
                System.out.println("Zadal jste neplatný řetězec: " + vstup);
            }
        }
    }
}