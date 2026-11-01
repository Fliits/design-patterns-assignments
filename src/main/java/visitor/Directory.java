package visitor;

import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> contents;

    public Directory(String name, List<FileSystemElement> contents) {
        this.name = name;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getContents() {
        return contents;
    }

    public void addElement(FileSystemElement element) {
        contents.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }
}
