package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing {
    public static void main(String[] args) {

        Scanner nacitac = new Scanner(System.in);  // Umožňuje číst vstup od uživatele

        // Nekonečná smyčka - program poběží, dokud ho uživatel neukončí.
        while (true) {
            System.out.println("Zadejte zlomky na sčítání (nebo stiskněte Enter pro ukončení): ");
            String vstup = nacitac.nextLine();  // Přečte celý řádek jako String

            // Pokud uživatel nezadá žádný vstup (stiskne Enter), ukončíme program
            if (vstup.trim().isEmpty()) {
                System.out.println("Program končí.");
                break;
            }

            try {
                // Předá řetězec metodě Fraction.parse a vypíše výsledek
                System.out.println("Zadal jste zlomek: " + Fraction.parse(vstup));
            } catch (Exception e) {
                // Pokud zpracování zlomku selže, vypíše se chybová zpráva
                System.out.println("Zadal jste neplatný řetězec: " + vstup);
            }
        }
    }
}
