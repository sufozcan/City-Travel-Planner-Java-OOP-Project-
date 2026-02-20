import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class AppController {

    private List<User> users;
    private User currentUser;
    private static final String USER_DATA_FILE = "users.json";
    
    public void launchApp() {
        users = loadUsersFromFile();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("👋 Welcome to City Travel Planner!");

            while (true) {
                System.out.println("\nDo you have an account?");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    if (login(scanner)) break;
                } else if (choice == 2) {
                    register(scanner);
                } else {
                    System.out.println("❗ Invalid choice. Try again.");
                }
            }

            while (true) {
                System.out.println("\nWelcome, " + currentUser.getUsername() + "!");
                System.out.println("Please choose an option:");
                System.out.println("1. Browse Cities and Explore (Read-only Mode)");
                System.out.println("2. Plan a Personalized Trip (Recommendation Mode)");
                System.out.println("3. View Trip Plans");
                System.out.println("4. Delete Trip Plan");
                System.out.println("5. Logout & Exit");

                int mode = scanner.nextInt();
                switch (mode) {
                    case 1 -> exploreMode(scanner);
                    case 2 -> tripPlanningMode(scanner);
                    case 3 -> viewSharedTripPlans(scanner);
                    case 4 -> deleteTripPlan(scanner);
                    case 5 -> {
                        System.out.println("👋 Goodbye!");
                        return;
                    }
                    default -> System.out.println("❗ Invalid selection.");
                }
            }
        }
    }
    private void deleteTripPlan(Scanner scanner) {
    List<TripPlan> history = currentUser.getTravelHistory();
    if (history == null || history.isEmpty()) {
        System.out.println("❗ You have no saved trip plans.");
        return;
    }

    System.out.println("\n🗑️ Your Trip Plans:");
    for (TripPlan plan : history) {
        System.out.println("- ID: " + plan.getPlanId() + " | Title: " + (plan.getPlanTitle() != null ? plan.getPlanTitle() : "(Unnamed)")
                + " | City: " + plan.getCityName()
                + " | Dates: " + plan.getFormattedStartDate() + " → " + new SimpleDateFormat("yyyy-MM-dd").format(plan.getEndDate())
                + (plan.isPublic() ? " | 🌍 Shared" : ""));
    }

    System.out.print("\nEnter the ID of the trip plan you want to delete: ");
    scanner.nextLine();
    String idToDelete = scanner.nextLine();

    TripPlan toRemove = null;
    for (TripPlan plan : history) {
        if (plan.getPlanId().equals(idToDelete)) {
            toRemove = plan;
            break;
        }
    }

    if (toRemove != null) {
        System.out.print("Are you sure you want to delete this trip? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            history.remove(toRemove);
            saveUsersToFile();
            System.out.println("✅ Trip plan deleted.");
        } else {
            System.out.println("❎ Deletion cancelled.");
        }
    } else {
        System.out.println("❗ No trip found with the given ID.");
    }
}
    private void viewSharedTripPlans(Scanner scanner) {
    List<TripPlan> myPlans = currentUser.getTravelHistory();
    if (myPlans != null && !myPlans.isEmpty()) {
    System.out.println("\n👤 Your Saved Plans:");
    for (TripPlan plan : myPlans) {
        System.out.println("\n📌 " + (plan.getPlanTitle() != null ? plan.getPlanTitle() : "Unnamed Trip"));
        System.out.println("- City: " + plan.getCityName());
        System.out.println("- Dates: " + new SimpleDateFormat("yyyy-MM-dd").format(plan.getStartDate())
            + " to " + new SimpleDateFormat("yyyy-MM-dd").format(plan.getEndDate()));
        System.out.println("- Budget: $" + plan.getBudget());
        System.out.println("- Visitors: " + plan.getNumberOfVisitors());
        System.out.println(plan.isPublic() ? "🔓 Shared with others" : "🔒 Private");
        
    if (plan.getItinerary() != null && !plan.getItinerary().isEmpty()) {
        System.out.println("🎯 Activities:");
        for (ItineraryItem item : plan.getItinerary()) {
            System.out.println("  • " + item.getActivityName() + " ($" + item.getPrice() + ")");
            try {
            Thread.sleep(500);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    } else {
        System.out.println("📭 No activities saved.");
    }
    }
    } else {
    System.out.println("\n📂 Viewing Shared Trip Plans...");
    System.out.println("\nℹ️ You have no saved plans.");
    }


        for (User user : users) {
    List<TripPlan> history = user.getTravelHistory();
    if (history != null && !history.isEmpty()) {
        for (TripPlan plan : history) {
            if (plan.isPublic()) {
                System.out.println("\n👤 Shared by: " + user.getUsername());
                System.out.println("- City: " + plan.getCityName());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("- Dates: " + formatter.format(plan.getStartDate())
                        + " to " + formatter.format(plan.getEndDate()));

                System.out.println("- Budget: $" + plan.getBudget());
                System.out.println("- Visitors: " + plan.getNumberOfVisitors());

                if (plan.getItinerary() != null && !plan.getItinerary().isEmpty()) {
                    System.out.println("🎯 Activities:");
                    for (ItineraryItem item : plan.getItinerary()) {
                        System.out.println("  • " + item.getActivityName() + " ($" + item.getPrice() + ")");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else {
                    System.out.println("📭 No activities saved.");
                }


                List<Review> reviews = plan.getReviews();
                if (reviews != null && !reviews.isEmpty()) {
                    System.out.println("⭐ Reviews:");
                    for (Review r : reviews) {
                        System.out.println("  " + r);
                    }
                } else {
                    System.out.println("🗂 No reviews yet.");
                }

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (!user.equals(currentUser)) {
                    String leaveReview;
                    while (true) {
                        System.out.print("Would you like to leave a review for this trip? (yes/no): ");
                        leaveReview = scanner.next();
                        if (leaveReview.equalsIgnoreCase("yes") || leaveReview.equalsIgnoreCase("no")) break;
                        System.out.println("❗ Please type only 'yes' or 'no'.");
                    }

                    if (leaveReview.equalsIgnoreCase("yes")) {
                        scanner.nextLine();
                        System.out.print("Leave a short comment: ");
                        String comment = scanner.nextLine();

                        int rating;
                        while (true) {
                            System.out.print("Give a rating (1–5): ");
                            try {
                                rating = Integer.parseInt(scanner.nextLine());
                                if (rating >= 1 && rating <= 5) break;
                                System.out.println("❗ Rating must be between 1 and 5.");
                            } catch (NumberFormatException e) {
                                System.out.println("❗ Invalid number. Try again.");
                            }
                        }

                        Review review = new Review(currentUser.getUsername(), comment, rating);
                        plan.addReview(review);
                        saveUsersToFile();
                        System.out.println("✅ Thanks for your feedback!");
                    }
                }
            }
        }
    }
}
    }


    private boolean login(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("✅ Login successful!");
                return true;
            }
        }

        System.out.println("❌ Invalid email or password.");
        return false;
    }

    private void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("❗ This email is already registered.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser = new User(username, email, password);
        users.add(newUser);
        currentUser = newUser;
        saveUsersToFile();

        System.out.println("✅ Registration complete.");
    }

    private void saveUsersToFile() {
        try (Writer writer = new FileWriter(USER_DATA_FILE)) {
            Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd") 
                .create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println("❗ Failed to save users: " + e.getMessage());
        }
    }

    private List<Activity> collectActivitiesManually(Scanner scanner, City city) {
    Map<String, List<Activity>> categorized = new LinkedHashMap<>();
    categorized.put("Cultural", new ArrayList<>());
    categorized.put("Adventure", new ArrayList<>());
    categorized.put("Nightlife", new ArrayList<>());
    categorized.put("Relaxation", new ArrayList<>());

    for (Activity a : city.getActivities()) {
        String key = a.getClass().getSimpleName();
        if (categorized.containsKey(key)) {
            categorized.get(key).add(a);
        }
    }

    List<Activity> selected = new ArrayList<>();
    int totalSelected = 0;
    int threshold = 7; 

    System.out.println("\n📋 Here are all available activities by category:");
    for (Map.Entry<String, List<Activity>> entry : categorized.entrySet()) {
        String category = entry.getKey();
        List<Activity> activities = entry.getValue();

        if (!activities.isEmpty()) {
            System.out.println("\n🎯 Category: " + category);
            for (int i = 0; i < activities.size(); i++) {
                System.out.println((i + 1) + ". " + activities.get(i).getName());
                try {
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            }
        }
    }

    for (Map.Entry<String, List<Activity>> entry : categorized.entrySet()) {
        String category = entry.getKey();
        List<Activity> activities = entry.getValue();

        if (activities.isEmpty()) continue;

        int count = 0;
        while (true) {
            System.out.print("\nHow many activities do you want to choose from " + category + "? ");
            try {
                count = scanner.nextInt();
                if (count < 0 || count > activities.size()) {
                    System.out.println("❗ Please choose between 0 and " + activities.size());
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("❗ Please enter a valid number.");
                scanner.nextLine();
            }
        }

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Select activity #" + (i + 1) + ": ");
                try {
                    int index = scanner.nextInt();
                    if (index >= 1 && index <= activities.size()) {
                        Activity selectedActivity = activities.get(index - 1);
                        if (selected.contains(selectedActivity)) {
                            System.out.println("❗ You’ve already selected this activity.");
                        } else {
                            selected.add(selectedActivity);
                            totalSelected++;
                            break;
                        }
                    } else {
                        System.out.println("❗ Invalid selection.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❗ Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            if (totalSelected >= threshold) {
                scanner.nextLine(); 
                String ans;
                while (true) {
                    System.out.print("You've selected " + totalSelected + " activities. Do you want to continue? (yes/no): ");
                    ans = scanner.nextLine().trim().toLowerCase();
                    if (ans.equals("yes") || ans.equals("no")) break;
                    System.out.println("❗ Please type only 'yes' or 'no'.");
                }

                if (ans.equals("no")) return selected;
                threshold += 3;
            }
        }
        }
        return selected;
    }

    private List<User> loadUsersFromFile() {
        try {
            File file = new File(USER_DATA_FILE);
            if (!file.exists()) return new ArrayList<>();

            Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

            Reader reader = new FileReader(file);
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(reader, userListType);

        } catch (IOException e) {
            System.out.println("❗ Failed to load users: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private Map<Integer, City> loadCities() {
        Map<Integer, City> cityOptions = new LinkedHashMap<>();
        cityOptions.put(1, CityData.getIstanbul());
        cityOptions.put(2, CityData.getParis());
        cityOptions.put(3, CityData.getRome());
        cityOptions.put(4, CityData.getBerlin());
        cityOptions.put(5, CityData.getBarcelona());
        return cityOptions;
    }

    private void exploreMode(Scanner scanner) {
        Map<Integer, City> cityOptions = loadCities();

        System.out.println("\nWhich city would you like to explore?");
        for (Map.Entry<Integer, City> entry : cityOptions.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }

        int selected = scanner.nextInt();
        City city = cityOptions.get(selected);

        if (city == null) {
            System.out.println("❌ Invalid selection.");
            return;
        }

        System.out.println("\n🌍 City: " + city.getName() + ", " + city.getCountry());
        System.out.println("📖 Description: " + city.getDescription());
        try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    System.out.println("\n🗓 Best Time(s) to Visit " + city.getName() + ":");
    List<BestTimeToVisit> bestTimes = city.getBestTimes();
    for (int i = 0; i < bestTimes.size(); i++) {
    BestTimeToVisit b = bestTimes.get(i);
    System.out.println("- Season: " + b.getSeason());
    System.out.println("  • Date Range: " + b.getDateRange());
    System.out.println("  • Temperature: " + b.getAvgTemperature());
    System.out.println("  • Popularity: " + b.getPopularity());
    System.out.println("  • Price Level: " + b.getPriceLevel());
    System.out.println("  • Recommended Stay: " + b.getRecommendedDays() + " days");
    System.out.println("  • Reason to Visit: " + b.getReasonToVisit());

    if (b.getSpecialEvents() != null && !b.getSpecialEvents().isEmpty()) {
        System.out.println("  • Notable Events:");
        for (String event : b.getSpecialEvents()) {
            System.out.println("    - " + event);
        }
    }
    System.out.println();

    if (i < bestTimes.size() - 1) {
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\n🌤 Climate:");
        for (SeasonalClimate c : city.getClimates()) {
            System.out.println("- " + c.getSeason() + ": " + c.getAverageTemperature() + "°C | Rainfall: " +
                    c.getRainfall() + "mm | Recommended Clothes: " + c.getSuggestedClothing());
            }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
        System.out.println("\n🚌 Transport:");
        for (TransportOption t : city.getTransportOptions()) {
            System.out.println("- " + t.getType() + " | " + t.getAvailability() + " | $" + t.getCost());
            }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
        System.out.println("\n🏨 Accommodations:");
        for (Accomodation a : city.getAccomodations()) {
            System.out.print("- " + a.getName() + " | $" + a.getPricePerNight() + " | 📍 " + a.getLocation());
            if (a.getUrl() != null && !a.getUrl().isEmpty()) {
                System.out.print(" | 🌐 " + a.getUrl());
            }
            System.out.println();
            }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
        System.out.println("\n🍽 Food Options:");
        for (FoodOption f : city.getFoodOptions()) {
            System.out.println("- " + f);
            }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
        System.out.println("\n🎯 Activities:");
        for (Activity a : city.getActivities()) {
            a.getDetails();
            try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }

        String browseInput;
        while (true) {
            System.out.println("\n🔎 Would you like to browse trip plans from other users?");
            System.out.print("Type 'yes' to view, or press Enter to skip: ");
            scanner.nextLine(); 
            browseInput = scanner.nextLine().trim().toLowerCase();

            if (browseInput.isEmpty()) {
                break; 
            } else if (browseInput.equals("yes")) {
                for (User user : users) {
                List<TripPlan> history = user.getTravelHistory();
                if (history != null && !history.isEmpty()) {
                    for (TripPlan plan : history) {
                        if (plan.isPublic()) {
                            System.out.println("\n👤 Shared by: " + user.getUsername());
                            System.out.println("- City: " + plan.getCityName());
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            System.out.println("- Dates: " + formatter.format(plan.getStartDate())
                                    + " to " + formatter.format(plan.getEndDate()));
                            System.out.println("- Budget: $" + plan.getBudget());
                            System.out.println("- Visitors: " + plan.getNumberOfVisitors());

                        
                            if (plan.getItinerary() != null && !plan.getItinerary().isEmpty()) {
                                System.out.println("🎯 Activities:");
                                for (ItineraryItem item : plan.getItinerary()) {
                                    System.out.println("  • " + item.getActivityName() + " ($" + item.getPrice() + ")");
                                    try {
                            Thread.sleep(500); 
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                                }
                            } else {
                                System.out.println("📭 No activities saved.");
                            }
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                            List<Review> reviews = plan.getReviews();
                            if (reviews != null && !reviews.isEmpty()) {
                                System.out.println("⭐ Reviews:");
                                for (Review r : reviews) {
                                    System.out.println("  " + r);
                                }
                            } else {
                                System.out.println("🗂 No reviews yet.");
                            }

                        }
                    }
                }
            }
            break;
        } else {
            System.out.println("❗ Please type 'yes' or press Enter to skip.");
        }
        }
    }

    private void tripPlanningMode(Scanner scanner) {
        Map<Integer, City> cityOptions = loadCities();

        System.out.println("\nSelect a city you'd like to visit:");
        for (Map.Entry<Integer, City> entry : cityOptions.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }

        int selected = scanner.nextInt();
        City selectedCity = cityOptions.get(selected);
        if (selectedCity == null) {
            System.out.println("❌ Invalid selection.");
            return;
        }

        TripPlan plan = createTripPlan(scanner, selectedCity);
        if (plan == null) return;
        
        String view = "";
        while (true) {
            System.out.print("Would you like to see recommendations? (yes/no): ");
            view = scanner.next();
            if (view.equalsIgnoreCase("yes") || view.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("❗ Please type 'yes' or 'no'.");
            }
        }

        if (view.equalsIgnoreCase("yes")) {
    recommendTripPlans(scanner, selectedCity, plan.getBudget(), plan.getTotalDays(), plan.getNumberOfVisitors(),
        plan.getStartDate().toLocalDate(),
        plan.getEndDate().toLocalDate());

        return;
    }

        showCityInfo(scanner, selectedCity, plan);
    }

    private TripPlan createTripPlan(Scanner scanner, City city) {
        LocalDate startDate;
        LocalDate endDate;
        long totalDays;
    System.out.println("\n🗓 Best Time(s) to Visit " + city.getName() + ":");
    List<BestTimeToVisit> bestTimes = city.getBestTimes();
    for (int i = 0; i < bestTimes.size(); i++) {
    BestTimeToVisit b = bestTimes.get(i);
    System.out.println("- Season: " + b.getSeason());
    System.out.println("  • Date Range: " + b.getDateRange());
    System.out.println("  • Temperature: " + b.getAvgTemperature());
    System.out.println("  • Popularity: " + b.getPopularity());
    System.out.println("  • Price Level: " + b.getPriceLevel());
    System.out.println("  • Recommended Stay: " + b.getRecommendedDays() + " days");
    System.out.println("  • Reason to Visit: " + b.getReasonToVisit());

    if (b.getSpecialEvents() != null && !b.getSpecialEvents().isEmpty()) {
        System.out.println("  • Notable Events:");
        for (String event : b.getSpecialEvents()) {
            System.out.println("    - " + event);
        }
    }
    System.out.println();

    if (i < bestTimes.size() - 1) {
        try {
            Thread.sleep(1500);     
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        }
    }       
        while (true) {
            try {
                System.out.print("Start date (YYYY-MM-DD): ");
                startDate = LocalDate.parse(scanner.next());

                if (startDate.isBefore(LocalDate.now())) {
                    System.out.println("❗ Start date cannot be in the past.");
                    continue;
                }

                System.out.print("End date (YYYY-MM-DD): ");
                endDate = LocalDate.parse(scanner.next());

                totalDays = ChronoUnit.DAYS.between(startDate, endDate);
                if (totalDays <= 0) {
                    System.out.println("❗ End date must be after start date.");
                } else break;

            } catch (DateTimeParseException e) {
                System.out.println("❗ Invalid date format. Please use YYYY-MM-DD.");
                scanner.nextLine(); 
            }
        }
        System.out.print("Number of visitors: ");
        int visitors = 0;
        while (true) {
            try {
                visitors = Integer.parseInt(scanner.next());
                if (visitors <= 0) {
                    System.out.println("❗ Please enter a positive number.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ Invalid number. Please enter an integer.");
                scanner.nextLine(); 
            }
        }

        double budget = 0;
        while (true) {
            System.out.print("Enter your total budget in USD: ");
            String input = scanner.next();
            try {
                budget = Double.parseDouble(input.replace("$", ""));
                if (budget <= 0) {
                    System.out.println("❗ Budget must be greater than 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ Invalid number format.");
                scanner.nextLine();
            }
        }

        TripPlan plan = new TripPlan(Date.valueOf(startDate), Date.valueOf(endDate), budget, (int) totalDays, visitors);

        plan.setCityName(city.getName());

        return plan;
    }

    private SeasonalClimate getClimateForDate(City city, LocalDate travelDate) {
    List<SeasonalClimate> climates = city.getClimates();

    for (SeasonalClimate climate : climates) {
        LocalDate startDate = LocalDate.of(travelDate.getYear(), climate.getStartSeasonDate().getMonth(), climate.getStartSeasonDate().getDayOfMonth());
        LocalDate endDate = LocalDate.of(travelDate.getYear(), climate.getEndSeasonDate().getMonth(), climate.getEndSeasonDate().getDayOfMonth());

        if (climate.getSeason().equals("Winter")) {
            if (travelDate.isBefore(startDate)) {
                startDate = startDate.minusYears(1); 
                endDate = endDate.minusYears(1); 
            }
        }
        if (endDate.isBefore(startDate)) {
            endDate = endDate.plusYears(1);
        }

        if ((travelDate.isEqual(startDate) || travelDate.isAfter(startDate)) &&
            (travelDate.isEqual(endDate) || travelDate.isBefore(endDate))) {
            return climate; 
        }
    }

    return null; 
}

    private void showCityInfo(Scanner scanner, City city, TripPlan plan) {
    System.out.println("\n🌍 City: " + city.getName() + ", " + city.getCountry());
    System.out.println("📖 Description: " + city.getDescription());
    try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    
    System.out.println("\n🌤 Climate:");

    java.util.Date utilDate = new java.util.Date(plan.getStartDate().getTime());
    LocalDate startDate = utilDate.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate();
    
    SeasonalClimate chosenClimate = getClimateForDate(city, startDate); 
    if (chosenClimate != null) {
        System.out.println("- " + chosenClimate.getSeason() + ": " + chosenClimate.getAverageTemperature() + "°C | Rainfall: " +
                chosenClimate.getRainfall() + "mm | Clothes: " + chosenClimate.getSuggestedClothing());
    } else {
        System.out.println("❗ No matching climate season found for the selected dates.");
    }
    try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    System.out.println("\n🚌 Transport:");
    for (TransportOption t : city.getTransportOptions()) {
        System.out.println("- " + t.getType() + " | " + t.getAvailability() + " | $" + t.getCost());
    }
    try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    System.out.println("\n🏨 Choose your accommodation:");
    List<Accomodation> accs = city.getAccomodations();
    for (int i = 0; i < accs.size(); i++) {
        Accomodation a = accs.get(i);
        System.out.print((i + 1) + ". " + a.getName() + " | $" + a.getPricePerNight() + " | 📍 " + a.getLocation());
        if (a.getUrl() != null && !a.getUrl().isEmpty()) System.out.print(" | 🌐 " + a.getUrl());
        System.out.println();
    }
    int accChoice = scanner.nextInt();
    Accomodation chosenAcc = accs.get(accChoice - 1);

    System.out.println("\n🍽 Food Recommendations:");
    for (FoodOption f : city.getFoodOptions()) {
        System.out.println("- " + f);
    }
     try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    List<Activity> selectedActivities = collectActivitiesManually(scanner, city);
    double activityCost = 0.0;
    System.out.println("\n🎯 Your Selected Activities:");
    for (Activity a : selectedActivities) {
 
        ItineraryItem item = new ItineraryItem(a.getName(), a.getPrice());

    item.setActivityName(a.getName());
    item.setPrice(a.getPrice());
    plan.addItineraryItem(item);  

    System.out.println("- " + a.getName());
    a.getDetails();  
    activityCost += a.getPrice() * plan.getNumberOfVisitors(); 
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    }
    System.out.println("\n📋 Trip Summary:");
    System.out.println("- City: " + city.getName());
    System.out.println("- Climate Season: " + chosenClimate.getSeason() + " | Recommended Clothes: " + chosenClimate.getSuggestedClothing());
    System.out.println("- Accommodation: " + chosenAcc.getName() + " | $" + chosenAcc.getPricePerNight());
    System.out.println("- Activities:");
    for (Activity a : selectedActivities) {
    System.out.println("  • " + a.getName() + " ($" + a.getPrice() + ")");
    }
    System.out.printf("- Total Activity Cost: $%.2f\n", activityCost);

    System.out.println("- Budget: $" + plan.getBudget());
    System.out.println("- Days: " + plan.getTotalDays());
    System.out.println("- Visitors: " + plan.getNumberOfVisitors());
    try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    double accommodationCost = chosenAcc.getPricePerNight() * plan.getTotalDays() * plan.getNumberOfVisitors();
    double estimatedTransportPerDay = 30.0;
    double transportCost = estimatedTransportPerDay * plan.getTotalDays() * plan.getNumberOfVisitors();
    double estimatedFoodPerDay = 15.0;
    double foodCost = estimatedFoodPerDay * plan.getTotalDays() * plan.getNumberOfVisitors();
    double totalEstimatedCost = accommodationCost + transportCost + foodCost + activityCost;

    System.out.println("\n💵 Estimated Trip Cost Breakdown:");
    System.out.printf("- Accommodation: $%.2f\n", accommodationCost);
    System.out.printf("- Transport: $%.2f\n", transportCost);
    System.out.printf("- Food (approx.): $%.2f\n", foodCost);
    System.out.printf("- Total Activity Cost: $%.2f\n", activityCost);
    System.out.printf("👉 Total Estimated Cost: $%.2f\n", totalEstimatedCost);
    System.out.print("\n📝 Now, please give a name to your trip plan (e.g., 'Rome Adventure'): ");
    scanner.nextLine(); 
    String planName = scanner.nextLine();
    plan.setPlanTitle(planName);
    if (totalEstimatedCost > plan.getBudget()) {
        System.out.println("⚠️ Warning: Your estimated cost exceeds your budget.");
    } else {
        System.out.println("✅ Your plan fits within your budget.");
    }

    String share;
    while (true) {
    System.out.print("Do you want to share this trip publicly? (yes/no): ");
    share = scanner.next();
    if (share.equalsIgnoreCase("yes") || share.equalsIgnoreCase("no")) break;
    System.out.println("❗ Please type only 'yes' or 'no'.");
    }

    if (share.equalsIgnoreCase("yes")) {
    plan.setPublic(true);
    System.out.println("🌍 Your trip is now shared with others.");
    }

    String save;
    while (true) {
    System.out.print("Do you want to save this trip to your profile? (yes/no): ");
    save = scanner.next();
    if (save.equalsIgnoreCase("yes") || save.equalsIgnoreCase("no")) break;
    System.out.println("❗ Please type only 'yes' or 'no'.");
    }

    if (save.equalsIgnoreCase("yes")) {
    currentUser.listPreviousTrips().add(plan);
    saveUsersToFile();
    System.out.println("✅ Trip saved to your profile.");
        }
    }

    private void recommendTripPlans(Scanner scanner, City city, double budget, int days, int visitors,LocalDate startDate, LocalDate endDate) {
        System.out.println("\n🎯 Please list your activity preferences in priority order.");
        System.out.println("Enter the activity types you prefer by number (1: Cultural, 2: Adventure, 3: Nightlife, 4: Relaxation) separated by commas.");
        System.out.print("For example: 1, 2, 4: ");
        scanner.nextLine();
        String preferences = scanner.nextLine();
        List<Integer> priorityList = new ArrayList<>();
        for (String preference : preferences.split(",")) {
            try {
                int num = Integer.parseInt(preference.trim());
                if (num >= 1 && num <= 4) {
                    priorityList.add(num);
                } else {
                    System.out.println("❗ Invalid activity number entered. Please enter a number between 1 and 4.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ Invalid input format. Please enter numbers only.");
                return;
            }
        }

        int totalActivities = (int) Math.ceil(days * 1.5); 
        List<Activity> selectedActivities = new ArrayList<>();
        for (int categoryNumber : priorityList) {
            String category = "";
            switch (categoryNumber) {
                case 1 -> category = "Cultural";
                case 2 -> category = "Adventure";
                case 3 -> category = "Nightlife";
                case 4 -> category = "Relaxation";
            }

            List<Activity> categoryActivities = getActivitiesForCategory(city, category);
            int activitiesToAdd = Math.min(categoryActivities.size(), totalActivities - selectedActivities.size());

            for (int i = 0; i < activitiesToAdd; i++) {
                selectedActivities.add(categoryActivities.get(i));
            }

            if (selectedActivities.size() >= totalActivities) {
                break;
            }
        }
        double hostelCost = calculateAccommodationCost(city, "Hostel", days, visitors);
        double hotelCost = calculateAccommodationCost(city, "Hotel", days, visitors);
        double airbnbCost = calculateAccommodationCost(city, "Airbnb", days, visitors);

        System.out.println("\n💵 Accommodation cost estimates for your trip:");
        System.out.println("1. Hostel: $" + hostelCost);
        System.out.println("2. Hotel: $" + hotelCost);
        System.out.println("3. Airbnb: $" + airbnbCost);

        System.out.print("\nPlease select your preferred accommodation (1: Hostel, 2: Hotel, 3: Airbnb): ");
        int accommodationChoice = scanner.nextInt();

        List<Accomodation> selectedAccommodation = new ArrayList<>();
        switch (accommodationChoice) {
            case 1: // Hostel
                selectedAccommodation = getAccommodationForType(city, "Hostel");
                break;
            case 2: // Hotel
                selectedAccommodation = getAccommodationForType(city, "Hotel");
                break;
            case 3: // Airbnb
                selectedAccommodation = getAccommodationForType(city, "Airbnb");
                break;
            default:
                System.out.println("❗ Invalid choice for accommodation.");
                return;
        }

        System.out.println("\n📋 Recommended Activities based on your preferences:");
        double activityCost = 0;
        for (Activity activity : selectedActivities) {
            String category = getActivityCategory(activity); 
            double activityPrice = activity.getPrice() * visitors;
            activityCost += activityPrice; 
            System.out.println("- " + activity.getName() + " | Type: " + category + " | Price per person: $" + activity.getPrice() + " | Total price for " + visitors + " visitors: $" + activityPrice);
            try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }
        double accommodationCost = 0.0;
        System.out.println("\n🏨 Accommodation Recommendations:");
        for (Accomodation acc : selectedAccommodation) {
            System.out.println("- " + acc.getName() + " | Price per Night: $" + acc.getPricePerNight() + " | Location: " + acc.getLocation());
            accommodationCost += acc.getPricePerNight() * days * visitors;
        }

        TripPlan plan = new TripPlan(Date.valueOf(startDate), Date.valueOf(endDate), budget, days, visitors);
        plan.setCityName(city.getName());

    for (Activity activity : selectedActivities) {
        ItineraryItem item = new ItineraryItem(activity.getName(), activity.getPrice());
        item.setActivityName(activity.getName());
        item.setPrice(activity.getPrice());
        plan.addItineraryItem(item);
    }


        System.out.print("\n📝 Give a name to your trip plan (e.g., 'Rome Adventure'): ");
        scanner.nextLine();
        String planName = scanner.nextLine();
        plan.setPlanTitle(planName);

        System.out.println("\n📋 Trip Summary:");
        System.out.println("- City: " + city.getName());
        System.out.println("- Total Budget: $" + budget);
        System.out.println("- Duration: " + days + " days");
        System.out.println("- Number of Visitors: " + visitors);
        System.out.println("- Activities: " + selectedActivities.size() + " activities");

        try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

        double transportCost = 30.0 * days * visitors;
        double foodCost = 15.0 * days * visitors;

        double totalEstimatedCost = accommodationCost + transportCost + foodCost + activityCost;

        System.out.println("\n💵 Estimated Trip Cost Breakdown:");
        System.out.printf("- Accommodation: $%.2f\n", accommodationCost);
        System.out.printf("- Transport: $%.2f\n", transportCost);
        System.out.printf("- Food (approx.): $%.2f\n", foodCost);
        System.out.printf("- Activities: $%.2f\n", activityCost);
        System.out.printf("👉 Total Estimated Cost: $%.2f\n", totalEstimatedCost);

        if (totalEstimatedCost > budget) {
            System.out.println("⚠️ Warning: Your estimated cost exceeds your budget.");
        } else {
            System.out.println("✅ Your plan fits within your budget.");
        }

        String save;

    String share;
    while (true) {
    System.out.print("Do you want to share this trip publicly? (yes/no): ");
    share = scanner.next();
    if (share.equalsIgnoreCase("yes") || share.equalsIgnoreCase("no")) break;
    System.out.println("❗ Please type only 'yes' or 'no'.");
    }

    if (share.equalsIgnoreCase("yes")) {
    plan.setPublic(true);  // ✅ önce plan güncellensin
    System.out.println("🌍 Your trip is now shared with others.");
    }


while (true) {
    System.out.print("Do you want to save this trip to your profile? (yes/no): ");
    save = scanner.next();
    if (save.equalsIgnoreCase("yes") || save.equalsIgnoreCase("no")) break;
    System.out.println("❗ Please type only 'yes' or 'no'.");
}

if (save.equalsIgnoreCase("yes")) {
    currentUser.listPreviousTrips().add(plan); 
    saveUsersToFile();
    System.out.println("✅ Trip saved to your profile.");
}

    }

    private List<Activity> getActivitiesForCategory(City city, String category) {
        List<Activity> categoryActivities = new ArrayList<>();
        for (Activity activity : city.getActivities()) {
            if (activity.getClass().getSimpleName().equalsIgnoreCase(category)) {
                categoryActivities.add(activity);
            }
        }
        return categoryActivities;
    }

    private String getActivityCategory(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private List<Accomodation> getAccommodationForType(City city, String type) {
        List<Accomodation> accommodationOptions = new ArrayList<>();
        for (Accomodation acc : city.getAccomodations()) {
            if (acc.getName().equalsIgnoreCase(type)) {
                accommodationOptions.add(acc);
            }
        }
        return accommodationOptions;
    }

    private double calculateAccommodationCost(City city, String type, int days, int visitors) {
        double totalCost = 0;
        for (Accomodation acc : city.getAccomodations()) {
            if (acc.getName().equalsIgnoreCase(type)) {
                totalCost += acc.getPricePerNight() * days * visitors;
            }
        }
        return totalCost;
    }
}