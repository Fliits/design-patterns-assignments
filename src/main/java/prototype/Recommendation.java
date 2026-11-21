package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Book> recommendedBooks;

    public Recommendation() {
        this.recommendedBooks = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void setRecommendedBooks(List<Book> recommendedBooks) {
        this.recommendedBooks = recommendedBooks;
    }

    public void addBook(Book book) {
        recommendedBooks.add(book);
    }

    public void removeBook(String bookTitle) {
        recommendedBooks.removeIf(book -> book.getTitle().equals(bookTitle));
    }

    @Override
    public Cloneable clone(){
        try {
            Recommendation recommendation = (Recommendation) super.clone();
            recommendation.recommendedBooks = new ArrayList<>();
            for (Book book : this.recommendedBooks) {
                recommendation.addBook((Book) book.clone());
            }
            return recommendation;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target Audience: ").append(targetAudience).append("\n");
        sb.append("Recommended Books:\n");
        for (Book book : recommendedBooks) {
            sb.append("- ").append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" (").append(book.getGenre()).append(")\n");
        }
        return sb.toString();
    }
}
