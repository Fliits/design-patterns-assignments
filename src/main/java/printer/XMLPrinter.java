package printer;

public class XMLPrinter implements Printer{

    private Printer printer;

    public XMLPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String xmlMessage = convertToXML(message);
        printer.print(xmlMessage);
    }

    private String convertToXML(String message) {
        return "<message>" + message + "</message>";
    }
}
