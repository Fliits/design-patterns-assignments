package abstract_factory;

public class CheckBoxB extends CheckBox {
    public String text = "[x]";

    @Override
    public void display() {
        System.out.println(text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
