package printer;

public class EncryptedPrinter implements Printer{
    private Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        printer.print(encryptedMessage);
    }

    private String encrypt(String message) {
        // Implement Caesar cipher with shift of 3
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base + 3) % 26;
                sb.append((char) (base + shifted));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
