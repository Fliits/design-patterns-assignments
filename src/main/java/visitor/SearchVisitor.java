package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchCriteria;
    private List<FileSystemElement> results;

    public SearchVisitor() {
        this.results = new ArrayList<>();
    }

    public List<FileSystemElement> getResults() {
        return results;
    }

    public void visitFile(File file) {
        if (file.getName().endsWith(searchCriteria)) {
            results.add(file);
        }
    }

    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.getContents()) {
            if (element instanceof File) {
                visitFile((File) element);
            } else if (element instanceof Directory) {
                visitDirectory((Directory) element);
            }
        }
    }

    public void searchByFileExtension(String extension, Directory directory) {
        searchCriteria = extension;
        this.visitDirectory(directory);
        for (FileSystemElement result : results) {
            if (result instanceof File && ((File) result).getName().endsWith(extension)) {
                System.out.println("Found file: " + ((File) result).getName());
            }
        }
    }
}
