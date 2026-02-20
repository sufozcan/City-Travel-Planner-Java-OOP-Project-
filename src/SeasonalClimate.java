import java.time.LocalDate;

public class SeasonalClimate {
    private final String season;
    private final LocalDate startSeasonDate; 
    private final LocalDate endSeasonDate;   
    private final double averageTemperature;
    private final double rainfall;
    private final String suggestedClothing;

    public SeasonalClimate(String season, LocalDate startSeasonDate, LocalDate endSeasonDate,
                           double averageTemperature, double rainfall, String suggestedClothing) {
        this.season = season;
        this.startSeasonDate = startSeasonDate;
        this.endSeasonDate = endSeasonDate;
        this.averageTemperature = averageTemperature;
        this.rainfall = rainfall;
        this.suggestedClothing = suggestedClothing;
    }

    public String getSeason() {
        return season;
    }

    public LocalDate getStartSeasonDate() {
        return startSeasonDate;
    }

    public LocalDate getEndSeasonDate() {
        return endSeasonDate;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getRainfall() {
        return rainfall;
    }

    public String getSuggestedClothing() {
        return suggestedClothing;
    }

    public boolean isInSeason(LocalDate startDate, LocalDate endDate) {
        return (startDate.isBefore(this.endSeasonDate) && endDate.isAfter(this.startSeasonDate));
    }
}
