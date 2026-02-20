import java.util.Date;

public class Nightlife extends Activity {
    private Date date;
    private double price;
    private String venueType;
    private String openingTime;
    private int ageRestriction;
    private String vibeDescription;

    @Override
    public void getDetails() {
        System.out.println("🎉 " + getName());
        System.out.println("   - Type: " + venueType);
        System.out.println("   - Opens at: " + openingTime + (ageRestriction > 0 ? " | Age: " + ageRestriction + "+" : ""));
        System.out.println("   - Vibe: " + vibeDescription);
        System.out.println();
    }

    public String getEventDetails() { return null; }
    public boolean isEntryAllowed(int userAge) { return userAge >= ageRestriction; }
    public String describeVibe() { return vibeDescription; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getVenueType() { return venueType; }
    public void setVenueType(String venueType) { this.venueType = venueType; }

    public String getOpeningTime() { return openingTime; }
    public void setOpeningTime(String openingTime) { this.openingTime = openingTime; }

    public int getAgeRestriction() { return ageRestriction; }
    public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }

    public void setVibeDescription(String vibeDescription) { this.vibeDescription = vibeDescription; }
}
