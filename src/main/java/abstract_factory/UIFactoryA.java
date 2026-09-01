package abstract_factory;

import java.util.Objects;

public class UIFactoryA extends UIFactory {
    @Override
    public Button createButton(String text) {
        ButtonA button = new ButtonA();
        if (!Objects.equals(text, "")){
            button.text = text;
        }
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextFieldA textField = new TextFieldA();
        if (!Objects.equals(text, "")){
            textField.text = text;
        }
        return textField;
    }

    @Override
    public CheckBox createCheckBox(String text) {
        CheckBoxA checkBox = new CheckBoxA();
        if (!Objects.equals(text, "")){
            checkBox.text = text;
        }
        return checkBox;
    }
}
