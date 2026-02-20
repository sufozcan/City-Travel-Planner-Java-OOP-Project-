import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripPlan {
    private final String planId;             
    private final Date startDate;
    private final Date endDate;
    private double budget;
    private boolean isPublic;
    private List<Review> reviews;
    private final int totalDays;
    private final int numberOfVisitors;
    private final List<ItineraryItem> itinerary;
    private String cityName;
    private String planTitle;

    public TripPlan(Date startDate, Date endDate, double budget, int totalDays, int numberOfVisitors) {
        this.planId = UUID.randomUUID().toString(); 
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.totalDays = totalDays;
        this.numberOfVisitors = numberOfVisitors;
        this.itinerary = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.isPublic = false;
        this.cityName = "Unknown";
        this.planTitle = null;
    }

    public String getPlanId() {
        return planId;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        if (reviews == null) reviews = new ArrayList<>();
        reviews.add(review);
    }

    public boolean hasReviews() {
        return reviews != null && !reviews.isEmpty();
    }

    public void addItineraryItem(ItineraryItem item) {
        itinerary.add(item);
    }

    public void removeItineraryItem(ItineraryItem item) {
        itinerary.remove(item);
    }

    public List<ItineraryItem> getItinerary() {
        return itinerary;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void editBudget(double newBudget) {
        this.budget = newBudget;
    }

    public boolean validatePlan() {
        return startDate != null && endDate != null && budget > 0 && totalDays > 0 && numberOfVisitors > 0;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getFormattedStartDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    @Override
    public String toString() {
        return """
               📍 Trip Plan Summary:
               - ID: """ + planId +
               "\n- Title: " + (planTitle != null ? planTitle : "(Unnamed Trip)") +
               "\n- City: " + cityName +
               "\n- Dates: " + startDate + " → " + endDate +
               "\n- Budget: $" + budget +
               "\n- Days: " + totalDays +
               "\n- Visitors: " + numberOfVisitors +
               (isPublic ? "\n🔓 Shared with others" : "\n🔒 Private");
    }
}
