package abstract_factory;

public class CheckBoxA extends CheckBox {
    public String text = "[+]";

    @Override
    public void display() {
        System.out.println(text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
