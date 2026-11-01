package visitor;

public class File implements FileSystemElement {
    private String name;
    private int fileSizeMB;

    public File(String name, int fileSizeMB) {
        this.name = name;
        this.fileSizeMB = fileSizeMB;
    }

    public String getName() {
        return name;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}
