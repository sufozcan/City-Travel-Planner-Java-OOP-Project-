public class FoodOption {
    private final String foodName;
    private final String placeName;
    private final String cityName;
    private final double price;

    public FoodOption(String foodName, String placeName, String cityName, double price) {
        this.foodName = foodName;
        this.placeName = placeName;
        this.cityName = cityName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCityName() {
        return cityName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return foodName + " at " + placeName + " (" + cityName + ") - $" + price;
    }
}
