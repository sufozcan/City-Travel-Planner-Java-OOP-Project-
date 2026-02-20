public class ItineraryItem {
    private String activityName;
    private double price;
    private String visitTime; 
    private int duration;     

    public ItineraryItem(String activityName, double price) {
        this.activityName = activityName;
        this.price = price;
    }

    public ItineraryItem(String activityName, double price, String visitTime, int duration) {
        this.activityName = activityName;
        this.price = price;
        this.visitTime = visitTime;
        this.duration = duration;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void editTime(String newTime, int newDuration) {
        this.visitTime = newTime;
        this.duration = newDuration;
    }

    public void removeItem() {
        // Bu method genellikle listeden silerken çağrılır, içerik değil dışarıdan liste kontrolü yapılır
    }

    @Override
    public String toString() {
        return activityName + " ($" + price + ")";
    }
}
