package chain_of_responsibility;

public class devSuggestionHandler extends Handler {
    @Override
    public void handle(Message msg) {
        if (msg.getType() == Message.MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevSuggestionHandler: Development suggestion logged.");
        } else {
            super.handle(msg);
        }
    }
}
