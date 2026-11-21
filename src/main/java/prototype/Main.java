package prototype;

public class Main {
    public static void main(String[] args) {
        //create several books of different genres and authors
        Book book1 = new Book();
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        book1.setGenre("Fiction");

        Book book2 = new Book();
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setGenre("Fiction");

        Book book3 = new Book();
        book3.setTitle("The Catcher in the Rye");
        book3.setAuthor("J.D. Salinger");
        book3.setGenre("Fiction");

        Book book4 = new Book();
        book4.setTitle("The Hobbit");
        book4.setAuthor("J.R.R. Tolkien");
        book4.setGenre("Fantasy");

        Book book5 = new Book();
        book5.setTitle("The Lord of the Rings");
        book5.setAuthor("J.R.R. Tolkien");
        book5.setGenre("Fantasy");

        // create a recommendation for fiction books
        Recommendation fictionRecommendation = new Recommendation();
        fictionRecommendation.setTargetAudience("Fiction Lovers");
        fictionRecommendation.addBook(book1);
        fictionRecommendation.addBook(book2);
        fictionRecommendation.addBook(book3);

        // create a recommendation for fantasy books
        Recommendation fantasyRecommendation = new Recommendation();
        fantasyRecommendation.setTargetAudience("Fantasy Lovers");
        fantasyRecommendation.addBook(book4);
        fantasyRecommendation.addBook(book5);

        // clone fiction recommendation
        Recommendation cloned = (Recommendation) fictionRecommendation.clone();

        // test the cloning by modifying the original recommendation and checking if the cloned recommendation remains unchanged
        System.out.println(cloned != fictionRecommendation); // should print true
        System.out.println(cloned.getRecommendedBooks() != fictionRecommendation.getRecommendedBooks()); // should print true
        System.out.println(cloned.getRecommendedBooks().get(0) != fictionRecommendation.getRecommendedBooks().get(0)); // should print true
        cloned.getRecommendedBooks().get(0).setTitle("The Great Gatsby from Sopranos");
        System.out.println(fictionRecommendation.getRecommendedBooks().get(0).getTitle()); // should print "The Great Gatsby" since the cloned recommendation is a deep copy and changes to it do not affect the original recommendation

        //remove a book from the original recommendation and check if the cloned recommendation remains unchanged
        fictionRecommendation.removeBook("To Kill a Mockingbird");
        System.out.println(fictionRecommendation.getRecommendedBooks().size()); // should print 2
        System.out.println(cloned.getRecommendedBooks().size()); // should print 3 since the cloned recommendation is a deep copy and changes to the original recommendation do not affect the cloned recommendation

        // finally print the original and cloned recommendations
        System.out.println(fictionRecommendation);
        System.out.println(fantasyRecommendation);
        System.out.println(cloned);
    }
}
