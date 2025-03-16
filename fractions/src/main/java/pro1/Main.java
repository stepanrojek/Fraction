package pro1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Vytvoření objektů pro adresáře, kde máme vstupní a výstupní soubory
        File inputDir = new File("C:/data/input");
        File outputDir = new File("C:/data/output");

        // Načtení všech souborů ve vstupním adresáři
        File[] inputFiles = inputDir.listFiles();

        // Pokud jsou soubory v adresáři, začneme je zpracovávat
        if (inputFiles != null) {
            // Pro každý soubor v seznamu
            for (File inputFile : inputFiles) {
                // Načteme data ze souboru do pole záznamů (ExamRecord)
                ExamRecord[] records = readInputFile(inputFile.toPath());

                // Vytvoření cesty pro výstupní soubor (soubor bude mít stejné jméno jako vstupní)
                String outputFilePath = new File(outputDir, inputFile.getName()).getAbsolutePath();

                // Zápis dat do výstupního souboru
                try (FileWriter writer = new FileWriter(outputFilePath)) {
                    // Pro každý záznam (ExamRecord) zapisujeme jméno a skóre do souboru
                    for (ExamRecord record : records) {
                        // Zápis jména a skóre do souboru, oddělené čárkou
                        writer.write(record.getName() + ", " + record.getScore().toString() + "\n");
                    }
                } catch (IOException e) {
                    // Pokud dojde k chybě při zápisu do souboru, vypíše chybovou hlášku
                    System.err.println("Chyba při zápisu");
                }
            }
        } else {
            // Pokud se nepodaří najít žádné soubory v adresáři, vypíše se hláška
            System.out.println("Nebyly nalezeny žádné soubory ve vstupním adresáři.");
        }
    }
    // Metoda pro načítání dat ze souboru
    public static ExamRecord[] readInputFile(Path path)
    {
        List<String> lines = null;
        try {
            // Načteme všechny řádky souboru jako seznam řetězců
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            // Pokud dojde k chybě při čtení souboru, vrátí prázdné pole
            return new ExamRecord[0];
        }
        // Seznam pro uchování výsledků (záznamů o osobách)
        List<ExamRecord> resultList = new ArrayList<>();

        // Pro každý řádek v seznamu
        for(String line : lines)
        {
            // Rozdělíme řádek na jméno a skóre podle oddělovačů ":", "=" nebo ";"
            String[] split= line.split("[:=;]");

            // Vytvoříme nový záznam a přidáme ho do seznamu
            resultList.add(new ExamRecord(
                    split[0], // První část je jméno
                    Fraction.parse(split[1]) // Druhá část je skóre, které parsujeme pomocí Fraction.parse()
            ));
        }
        // Vrátíme seznam záznamů jako pole
        return resultList.toArray(new ExamRecord[0]);
    }

}
