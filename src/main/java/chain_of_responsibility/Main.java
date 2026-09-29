package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler compensationHandler = new compensationHandler();
        Handler devSuggestionHandler = new devSuggestionHandler();
        Handler contactHandler = new contactHandler();
        Handler feedbackHandler = new feedbackHandler();

        // Set up the chain of responsibility
        compensationHandler.setNextHandler(devSuggestionHandler);
        devSuggestionHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(feedbackHandler);

        // Create requests
        Message request1 = new Message(Message.MessageType.COMPENSATION_CLAIM, "Request for compensation", "user1@example.com");
        Message request2 = new Message(Message.MessageType.DEVELOPMENT_SUGGESTION, "Request for development suggestion", "user2@example.com");
        Message request3 = new Message(Message.MessageType.CONTACT_REQUEST, "Request for contact", "user3@example.com");
        Message request4 = new Message(Message.MessageType.OTHER_FEEDBACK, "Request for feedback", "user4@example.com");

        // create a bad request
        Message request5 = new Message(null, "Request with no type", "user5@example.com");

        // Process requests
        compensationHandler.handle(request1);
        compensationHandler.handle(request2);
        compensationHandler.handle(request3);
        compensationHandler.handle(request4);
        compensationHandler.handle(request5);
    }
}
