package abstract_factory;

public class Main {
    static void main() {
        UIFactory factory = new UIFactoryA();
        //UIFactory factory = new UIFactoryB();

        CheckBox checkBox = factory.createCheckBox("");
        Button button = factory.createButton("");
        TextField textField = factory.createTextField("");

        textField.display();
        button.display();
        checkBox.display();
        textField.display();
    }
}
