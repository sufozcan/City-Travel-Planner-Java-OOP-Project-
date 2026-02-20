public class Review {
    private final String reviewerName;
    private final String comment;
    private final int rating;

    public Review(String reviewerName, String comment, int rating) {
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
public String toString() {
    return "👤 " + reviewerName + " (" + rating + "/5): " + comment;
}

}
