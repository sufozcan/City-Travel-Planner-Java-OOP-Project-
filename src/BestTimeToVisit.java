import java.util.List;

public class BestTimeToVisit {
    private String season;
    private String popularity;
    private String avgTemperature;
    private int recommendedDays;
    private String priceLevel;
    private List<String> specialEvents;
    private String dateRange;
    private String reasonToVisit;

    public BestTimeToVisit(String season, String popularity, String avgTemperature, int recommendedDays, String priceLevel, List<String> specialEvents, String dateRange, String reasonToVisit) {
        this.season = season;
        this.popularity = popularity;
        this.avgTemperature = avgTemperature;
        this.recommendedDays = recommendedDays;
        this.priceLevel = priceLevel;
        this.specialEvents = specialEvents;
        this.dateRange = dateRange;
        this.reasonToVisit = reasonToVisit;
    }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getPopularity() { return popularity; }
    public void setPopularity(String popularity) { this.popularity = popularity; }

    public String getAvgTemperature() { return avgTemperature; }
    public void setAvgTemperature(String avgTemperature) { this.avgTemperature = avgTemperature; }

    public int getRecommendedDays() { return recommendedDays; }
    public void setRecommendedDays(int recommendedDays) { this.recommendedDays = recommendedDays; }

    public String getPriceLevel() { return priceLevel; }
    public void setPriceLevel(String priceLevel) { this.priceLevel = priceLevel; }

    public List<String> getSpecialEvents() { return specialEvents; }
    public void setSpecialEvents(List<String> specialEvents) { this.specialEvents = specialEvents; }

    public String getDateRange() { return dateRange; }
    public void setDateRange(String dateRange) { this.dateRange = dateRange; }

    public String getReasonToVisit() { return reasonToVisit; }
    public void setReasonToVisit(String reasonToVisit) { this.reasonToVisit = reasonToVisit; }

    public String getCrowdLevel() {
        return popularity;
    }

    public String getTemperatureRange() {
        return avgTemperature;
    }
}
