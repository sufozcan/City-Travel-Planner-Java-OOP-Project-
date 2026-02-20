import java.util.List;

public class City {
    private final String name;
    private final String country;
    private final String description;
    private final List<Place> places;
    private final List<TransportOption> transportOptions;
    private final List<SeasonalClimate> climates;
    private final List<Accomodation> accomodations;
    private final List<BestTimeToVisit> bestTimes;
    private final List<Activity> activities;
    private final List<FoodOption> foodOptions;

    public City(String name, String country, String description,
                List<Place> places,
                List<TransportOption> transports,
                List<SeasonalClimate> climates,
                List<Accomodation> accomodations,
                List<BestTimeToVisit> bestTimes,
                List<Activity> activities,
                List<FoodOption> foodOptions) {

        this.name = name;
        this.country = country;
        this.description = description;
        this.places = places;
        this.transportOptions = transports;
        this.climates = climates;
        this.accomodations = accomodations;
        this.bestTimes = bestTimes;
        this.activities = activities;
        this.foodOptions = foodOptions;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public List<TransportOption> getTransportOptions() {
        return transportOptions;
    }

    public List<SeasonalClimate> getClimates() {
        return climates;
    }

    public List<Accomodation> getAccomodations() {
        return accomodations;
    }

    public List<BestTimeToVisit> getBestTimes() {
        return bestTimes;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<FoodOption> getFoodOptions() {
        return foodOptions;
    }
}
