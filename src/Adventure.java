import java.util.Date;
import java.util.List;

public class Adventure extends Activity {
    private Date date;
    private double price;
    private String difficultyLevel;
    private boolean equipmentRequired;
    private String description;
    private List<String> requiredEquipment;

    @Override
public void getDetails() {
    System.out.println("🧗 " + getName());
    System.out.println("   - Description: " + (description != null ? description : "No description provided"));
    System.out.println("   - Difficulty: " + getDifficultyVisual());
    if (equipmentRequired) {
        String equipment = requiredEquipment != null ? String.join(", ", requiredEquipment) : "Equipment info not available";
        System.out.println("   - Equipment: " + equipment);
    } else {
        System.out.println("   - Equipment: None needed");
    }
    System.out.println();
}


    private String getDifficultyVisual() {
        return switch (difficultyLevel.toLowerCase()) {
            case "easy" -> "🟢 Easy";
            case "medium" -> "🟡 Medium";
            case "hard" -> "🔴 Hard";
            default -> difficultyLevel;
        };
    }

    public String getEventDetails() {
        return "Difficulty: " + difficultyLevel + ", Equipment: " + (equipmentRequired ? "Yes" : "No");
    }

    public void showSafetyInstructions() {
        System.out.println("⚠️ Always wear a helmet and follow your guide’s instructions.");
    }

    public boolean requiresOwnEquipment() {
        return equipmentRequired;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public boolean isEquipmentRequired() { return equipmentRequired; }
    public void setEquipmentRequired(boolean equipmentRequired) { this.equipmentRequired = equipmentRequired; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getRequiredEquipment() { return requiredEquipment; }
    public void setRequiredEquipment(List<String> requiredEquipment) { this.requiredEquipment = requiredEquipment; }
}
