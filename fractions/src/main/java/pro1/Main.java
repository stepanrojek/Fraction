package pro1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Načtení souborů z adresáře "C:/data/input"
        // Vytvoříme objekt File, který ukazuje na složku obsahující vstupní soubory
        File inputDir = new File("C:/data/input");

        // Získáme všechny soubory v adresáři (pokud existují)
        File[] inputFiles = inputDir.listFiles();

        // Pro každý soubor v seznamu souborů provádíme operace
        for (File inputFile : inputFiles) {
            System.out.println("Reading " + inputFile);  // Vytiskneme název souboru, který se právě čte
            // Načteme data ze souboru do pole záznamů (ExamRecord)
            ExamRecord[] records = readInputFile(inputFile.toPath());

            // Vytvoříme výstupní soubor ve složce "C:/data/output"
            // Výstupní soubor bude mít stejný název jako vstupní
            File outputFile = new File("C:/data/output/" + inputFile.getName());
            // Zápis záznamů do výstupního souboru
            writeOutputFile(outputFile, records);
        }
    }

    // Metoda pro načítání dat ze souboru
    public static ExamRecord[] readInputFile(Path path) {
        List<String> lines = null;
        try {
            // Načteme všechny řádky souboru jako seznam řetězců
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            // Pokud dojde k chybě při čtení souboru, vypíšeme chybu a vrátíme prázdné pole
            System.err.println("Chyba při čtení souboru: " + path);
            return new ExamRecord[0];
        }

        // Seznam pro uchování výsledků (záznamů o osobách)
        List<ExamRecord> resultList = new ArrayList<>();
        // Pro každý řádek ve vstupním souboru
        for (String line : lines) {
            // Rozdělíme řádek na dvě části: jméno a skóre
            String[] split = line.split(",");
            if (split.length == 2) {  // Ověření správného formátu (jméno, skóre)
                String name = split[0].trim();  // Jméno osoby
                // Parsování skóre, které je ve formě zlomku
                Fraction score = Fraction.parse(split[1].trim());
                // Přidáme nový záznam do seznamu
                resultList.add(new ExamRecord(name, score));
            } else {
                // Pokud formát řádku není platný, vypíšeme chybu
                System.err.println("Neplatný řádek: " + line);
            }
        }
        // Vrátíme seznam záznamů jako pole
        return resultList.toArray(new ExamRecord[0]);
    }

    // Metoda pro zápis dat do výstupního CSV souboru
    public static void writeOutputFile(File outputFile, ExamRecord[] records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Pro každý záznam (ExamRecord) zapisujeme jeho jméno a skóre do souboru
            for (ExamRecord record : records) {
                writer.write(record.getName() + "," + record.getScore() + "\n");  // Formát "jméno,skóre"
            }
        } catch (IOException e) {
            // Pokud dojde k chybě při zápisu do souboru, vypíšeme chybu
            System.err.println("Chyba při zápisu do souboru: " + outputFile);
        }
    }
}
