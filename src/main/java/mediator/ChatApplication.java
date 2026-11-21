package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApplication extends Application {
        @Override
        public void start(Stage stage) {
            App app = new App();
            ClientController aliceController = new ClientController("Alice", app);
            ClientController bobController = new ClientController("Bob", app);
            ClientController carolController = new ClientController("Carol", app);

            app.registerClient(new Client("Alice", aliceController));
            app.registerClient(new Client("Bob", bobController));
            app.registerClient(new Client("Carol", carolController));

            app.start(stage);
        }
}
