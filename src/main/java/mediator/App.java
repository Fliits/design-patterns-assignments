package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    private final Map<String, ClientController> controllers = new LinkedHashMap<>();
    private final Map<String, TextArea> clientViews = new LinkedHashMap<>();
    private Stage stage;
    
    public void registerController(ClientController controller) {
        controllers.put(controller.getUsername(), controller);
    }

    public void registerClient(Client client) {
        controllers.get(client.getUsername()).setClient(client);
    }

    public void start(Stage stage) {
        this.stage = stage;
        int index = 0;
        for (String username : controllers.keySet()) {
            Stage clientStage = index++ == 0
                    ? stage
                    : new Stage();
            createClientView(username, clientStage);
        }
    }

    private void createClientView(String username, Stage clientStage) {
        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);
        messageArea.setWrapText(true);
        messageArea.setPrefRowCount(12);
        clientViews.put(username, messageArea);

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient username");

        TextField messageField = new TextField();
        messageField.setPromptText("Write a message");
        HBox.setHgrow(messageField, Priority.ALWAYS);

        Button sendButton = new Button("Send");
        sendButton.setDefaultButton(true);
        sendButton.setOnAction(event -> sendFromUi(username, recipientField, messageField));

        GridPane form = new GridPane();
        form.setHgap(8);
        form.setVgap(8);
        form.setPadding(new Insets(10));
        form.add(new Label("Recipient:"), 0, 0);
        form.add(recipientField, 1, 0);
        form.add(new Label("Message:"), 0, 1);
        form.add(messageField, 1, 1);
        form.add(sendButton, 2, 1);
        GridPane.setHgrow(recipientField, Priority.ALWAYS);
        GridPane.setHgrow(messageField, Priority.ALWAYS);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setCenter(messageArea);
        root.setBottom(form);
        BorderPane.setMargin(form, new Insets(10, 0, 0, 0));

        clientStage.setTitle(username + " - Mediator Chat");
        clientStage.setScene(new Scene(root, 600, 400));
        clientStage.show();

        messageField.setOnAction(event -> sendFromUi(username, recipientField, messageField));
    }

    private void sendFromUi(String sender, TextField recipientField, TextField messageField) {
        String recipient = recipientField.getText().trim();
        String message = messageField.getText().trim();

        if (recipient.isEmpty() || message.isEmpty()) {
            return;
        }

        ClientController senderController = controllers.get(sender);
        String canonicalRecipient = getCanonicalUsername(recipient);
        if (senderController != null && canonicalRecipient != null) {
            senderController.sendMessage(canonicalRecipient, message);
            messageField.clear();
        }
    }

    private String getCanonicalUsername(String username) {
        for (String registeredUsername : controllers.keySet()) {
            if (registeredUsername.equalsIgnoreCase(username)) {
                return registeredUsername;
            }
        }
        return null;
    }

    public void sendMessage(String sender, String recipient, String message) {
        if (message == null || message.trim().isEmpty()) {
            return;
        }

        String canonicalRecipient = getCanonicalUsername(recipient);
        if (canonicalRecipient == null) {
            return;
        }

        ClientController targetController = controllers.get(canonicalRecipient);
        if (targetController == null) {
            return;
        }

        targetController.receiveMessage(sender, message);
        appendMessage(sender, canonicalRecipient, message);
    }

    public void appendMessage(String sender, String recipient, String message) {
        String line = sender + " to " + recipient + ": " + message + System.lineSeparator();
        TextArea senderView = clientViews.get(sender);
        if (senderView != null) {
            senderView.appendText(line);
        }

        if (!recipient.equals(sender)) {
            TextArea recipientView = clientViews.get(recipient);
            if (recipientView != null) {
                recipientView.appendText(line);
            }
        }
    }

    public void receiveMessage(String sender, String recipient, String message) {
        appendMessage(sender, recipient, message);
    }
}
