package chain_of_responsibility;

public class compensationHandler extends Handler {
    @Override
    public void handle(Message msg) {
        if (msg.getType() == Message.MessageType.COMPENSATION_CLAIM) {
            System.out.println("CompensationHandler: Compensation claim forwarded for review.");
        } else {
            super.handle(msg);
        }
    }
}
