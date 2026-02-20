import java.util.List;

public class Place {
    private String type;
    private double cost;
    private String openingHours;
    private List<PlaceTag> tags;

    public void showDetails() {}
    public void addReview(Review review) {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<PlaceTag> getTags() {
        return tags;
    }

    public void setTags(List<PlaceTag> tags) {
        this.tags = tags;
    }
}