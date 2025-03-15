package pro1;

import java.util.regex.Pattern;

public class Fraction extends Number {
    private long n; // Čitatel
    private long d; // Jmenovatel

    // Konstruktor pro Fraction, který automaticky zjednodušuje zlomek.
    public Fraction(long n, long d) {
        long g = Utils.gcd(n, d); // Největší společný dělitel
        this.n = n / g; // Čitatel zjednodušeného zlomku
        this.d = d / g; // Jmenovatel zjednodušeného zlomku
    }

    // Sčítání dvou zlomků
    public Fraction add(Fraction other) {
        return new Fraction(
                n * other.d + other.n * d,  // nový čitatel
                d * other.d  // nový jmenovatel
        );
    }

    // Statická metoda pro parsování řetězce a vytvoření zlomku
    public static Fraction parse(String s) {
        s = s.replace(" ", "");  // Odstranění mezer
        String[] split = s.split(Pattern.quote("+"));  // Rozdělení na části, pokud je součástí vícero zlomků
        Fraction sum = new Fraction(0, 1);  // Začneme s nulovým zlomkem
        for (String part : split) {
            Fraction partFraction;
            if (part.contains("%")) { // Pokud řetězec obsahuje %, bude to procento
                partFraction = new Fraction(
                        Long.parseLong(part.replace("%", "")),  // Získání čitatele
                        100  // Jmenovatel je 100
                );
            } else { // Pokud je to klasický zlomek
                String[] split2 = part.split("/");  // Rozdělení na čitatele a jmenovatele
                partFraction = new Fraction(
                        Long.parseLong(split2[0]),
                        Long.parseLong(split2[1])
                );
            }
            sum = sum.add(partFraction);  // Přičteme tento zlomek k součtu
        }
        return sum;  // Vracíme součet zlomků
    }

    // Metoda pro převod zlomku na řetězec
    public String toString() {
        return n + "/" + d;  // Vytvoří formát "čitatel/jmenovatel"
    }

    @Override
    public int intValue() {
        return (int) (n / d);  // Získáme celočíselnou hodnotu zlomku
    }

    @Override
    public long longValue() {
        return n / d;  // Získáme celočíselnou hodnotu zlomku jako long
    }

    @Override
    public float floatValue() {
        return (float) n / (float) d;  // Převod zlomku na float
    }

    @Override
    public double doubleValue() {
        return (double) n / (double) d;  // Převod zlomku na double
    }
}