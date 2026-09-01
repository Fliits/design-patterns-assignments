package abstract_factory;

public class ButtonA extends Button {
    public String text = "\u001B[32mPress Here!\u001B[0m";

    @Override
    public void display() {
        System.out.println(text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
