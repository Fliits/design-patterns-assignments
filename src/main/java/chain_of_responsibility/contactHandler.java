package chain_of_responsibility;

public class contactHandler extends Handler {
    @Override
    public void handle(Message msg) {
        if (msg.getType() == Message.MessageType.CONTACT_REQUEST) {
            System.out.println("ContactHandler: Contact request forwarded to recipient.");
        } else {
            super.handle(msg);
        }
    }
}
