import java.util.List;

public abstract class Activity {
    private String name;
    private String location;
    private int duration;
    private List<PlaceTag> tags;

    public void joinActivity() {
        System.out.println("Joining " + name);
    }

    public abstract void getDetails();
    
    public abstract double getPrice();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public List<PlaceTag> getTags() { return tags; }
    public void setTags(List<PlaceTag> tags) { this.tags = tags; }
}