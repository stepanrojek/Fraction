package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing {
    public static void main(String[] args){

        Scanner nacitac = new Scanner(System.in); //umožňuje číst vstup od uživatele
     System.out.println("Zadejte zlomky na sčítání: ");
     String zlomky = nacitac.nextLine(); //přečte celý řádek jako String

     try{
         System.out.println("Zadal jste zlomek: " + Fraction.parse(zlomky));
     }
     //převede řetězec na zlomek.

     catch (Exception e){
         System.out.println("Zadal jste neplatný řetězec: " + zlomky);
     }
     //pokud selže (například při zadání "ABC"), program zobrazí chybovou zprávu.


    }
}
