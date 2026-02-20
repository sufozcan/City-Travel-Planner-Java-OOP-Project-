public class Accomodation {
    private final String name;
    private final double pricePerNight;
    private final String location;
    private final String url;

    public Accomodation(String name, double pricePerNight, String location, String url) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.location = location;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }
}
