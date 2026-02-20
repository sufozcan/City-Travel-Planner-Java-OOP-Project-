public class Relaxation extends Activity {
    private double price;
    private String locationType;
    private boolean includesMassage;
    private String description;

    @Override
    public void getDetails() {
        System.out.println("🧘 " + getName());

        String locationTypeDisplay = (locationType != null) ? locationType : "Unknown type";
        System.out.println("   - Location: " + getLocation() + " (" + locationTypeDisplay + ")");

        System.out.println("   - Description: " + (description != null ? description : "No description provided"));
        System.out.println("   - Massage Included: " + (includesMassage ? "Yes" : "No"));
        System.out.println();
    }

    public String getTourInfo() {
        return "Relaxation spot at " + getLocation() + (includesMassage ? " (Massage included)" : "");
    }

    public void printRelaxationTips() {
        System.out.println("💡 Tip: Wear comfortable clothes and stay hydrated for maximum relaxation.");
    }
    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getLocationType() { return locationType; }
    public void setLocationType(String locationType) { this.locationType = locationType; }

    public boolean isIncludesMassage() { return includesMassage; }
    public void setIncludesMassage(boolean includesMassage) { this.includesMassage = includesMassage; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
