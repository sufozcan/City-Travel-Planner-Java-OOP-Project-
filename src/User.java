import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    private String password;
    private List<Place> savedPlaces;
    private List<TripPlan> travelHistory;

    public User() {
        this.savedPlaces = new ArrayList<>();
        this.travelHistory = new ArrayList<>();
    }
    public List<TripPlan> getSharedTripPlans() {
    return travelHistory.stream()
        .filter(TripPlan::isPublic)
        .collect(Collectors.toList());
}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.savedPlaces = new ArrayList<>();
        this.travelHistory = new ArrayList<>();
    }

    public void login() {}
    public void logout() {}

    public void savePlace(Place place) {
        savedPlaces.add(place);
    }

    public List<Place> viewSavedPlaces() {
        return savedPlaces;
    }

    public List<TripPlan> listPreviousTrips() {
        return travelHistory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Place> getSavedPlaces() {
        return savedPlaces;
    }

    public void setSavedPlaces(List<Place> savedPlaces) {
        this.savedPlaces = savedPlaces;
    }

    public List<TripPlan> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(List<TripPlan> travelHistory) {
        this.travelHistory = travelHistory;
    }
}
