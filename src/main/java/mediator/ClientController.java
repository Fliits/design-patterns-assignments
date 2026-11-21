package mediator;

public class ClientController {
    private final String username;
    private final App chatApp;
    private Client client;

    public ClientController(String username, App chatApp) {
        this.username = username;
        this.chatApp = chatApp;
        chatApp.registerController(this);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        chatApp.sendMessage(username, recipient, message);
    }

    public void receiveMessage(String sender, String message) {
        if (client != null) {
            client.receiveMessage(sender, message);
        }
    }
}
