package chain_of_responsibility;

public class feedbackHandler extends Handler {
    @Override
    public void handle(Message msg) {
        if (msg.getType() == Message.MessageType.OTHER_FEEDBACK) {
            System.out.println("FeedbackHandler: Feedback message analysed, generating response...");
        } else {
            super.handle(msg);
        }
    }
}
