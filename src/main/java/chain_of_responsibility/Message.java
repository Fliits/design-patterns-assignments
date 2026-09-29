package chain_of_responsibility;

public class Message {
    public Message(MessageType messageType, String messageContent, String senderEmail) {
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType messageType;
    public String messageContent;
    public String senderEmail;

    public enum MessageType {
        COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, OTHER_FEEDBACK
    }

    public MessageType getType() {
        return messageType;
    }
}
