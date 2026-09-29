package chain_of_responsibility;

public class Handler {

    private Handler nextHandler;

    public void handle(Message msg) {
        if (nextHandler != null) {
            nextHandler.handle(msg);
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getHandler() {
        return nextHandler;
    }
}
