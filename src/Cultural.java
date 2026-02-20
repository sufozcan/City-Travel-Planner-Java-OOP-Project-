import java.util.Date;

public class Cultural extends Activity {
    private Date date;
    private double price;
    private String venue;
    private boolean guideIncluded;
    private String description;

    @Override
    public void getDetails() {
        System.out.println("🎭 " + getName());
        System.out.println("   - Description: " + description);
        System.out.println("   - Venue: " + venue + ", Guide: " + (guideIncluded ? "Yes" : "No"));
        System.out.println();
    }

    public String getEventDetails() { return null; }
    public boolean checkLanguageSupport(String preferredLang) { return false; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public boolean isGuideIncluded() { return guideIncluded; }
    public void setGuideIncluded(boolean guideIncluded) { this.guideIncluded = guideIncluded; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
