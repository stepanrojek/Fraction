package pro1;

public class ExamRecord {
    private String name;  // Jméno osoby
    private Fraction score;  // Skóre ve formě zlomku

    // Konstruktor pro vytvoření záznamu o osobě a jejím skóre
    public ExamRecord(String name, Fraction score) {
        this.name = name;  // Přiřazení jména
        this.score = score;  // Přiřazení skóre
    }

    // Getter pro jméno
    public String getName() {
        return name;
    }

    // Getter pro skóre
    public Fraction getScore() {
        return score;
    }
}