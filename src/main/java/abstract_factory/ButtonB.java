package abstract_factory;

public class ButtonB extends Button {
    public String text = "\u001b[32mpress here.\u001b[0m";

    @Override
    public void display() {
        System.out.println(text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
