package mediator;

public class Client {
    private final String username;
    private final ClientController controller;

    public Client(String username, ClientController controller) {
        this.username = username;
        this.controller = controller;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        if (controller != null) {
            controller.sendMessage(recipient, message);
        }
    }

    public void receiveMessage(String sender, String message) {
        // Delivery is mediated by ClientController.
    }
}
