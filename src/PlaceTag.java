public class PlaceTag {
    private String name;
    private String description;

    public String displayTag() { return null; }
    public void assignToPlace(Place place) {}
    public void assignToActivity(Activity activity) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}