package visitor;

public interface FileSystemVisitor {
    public void visitFile(File file);
    public void visitDirectory(Directory directory);
}
