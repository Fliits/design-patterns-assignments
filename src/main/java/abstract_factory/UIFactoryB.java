package abstract_factory;

import java.util.Objects;

public class UIFactoryB extends UIFactory {
    @Override
    public Button createButton(String text) {
        ButtonB button = new ButtonB();
        if (!Objects.equals(text, "")) {
            button.text = text;
        }
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        if (!Objects.equals(text, "")) {
            textField.text = text;
        }
        return textField;
    }

    @Override
    public CheckBox createCheckBox(String text) {
        CheckBoxB checkBox = new CheckBoxB();
        if (!Objects.equals(text, "")) {
            checkBox.text = text;
        }
        return checkBox;
    }
}
