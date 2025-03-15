package pro1;

import java.util.Scanner;

public class InteractiveDoubleParsing {
    public static void main(String[] args){
        Scanner nacitac = new Scanner(System.in);
        Double cislo = null;

        // Nekonečná smyčka - program poběží, dokud ho uživatel neukončí.
        while(true) {
            System.out.println("Zadejte číslo: ");
            String vstup = nacitac.nextLine();
            try{
                //prevadi vstup na desetinne cislo
                cislo = Double.parseDouble(vstup);
                // Pokud se převod podaří, vypíše číslo
                System.out.println("Zadal jste číslo: " + cislo);

            }
            catch(Exception e){
                // Pokud převod selže (např. kvůli zadání "ABC"), program vypíše chybovou zprávu
                System.out.println("Zadal jste neplatný řetězec: " + vstup);
            }

        }
        
    }
}
