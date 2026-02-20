public class TransportOption {
    private final String type;
    private final double cost;
    private final String availability;

    public TransportOption(String type, double cost, String availability) {
        this.type = type;
        this.cost = cost;
        this.availability = availability;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    public String getAvailability() {
        return availability;
    }
}
