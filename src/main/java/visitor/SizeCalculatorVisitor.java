package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getFileSizeMB(); // Simplified size calculation
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.getContents()) {
            if (element instanceof File) {
                totalSize += ((File) element).getFileSizeMB();
            } else if (element instanceof Directory) {
                visitDirectory((Directory) element);
            }
        }
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void calculateTotalSize(Directory directory) {
        totalSize = 0; // Reset total size before calculation
        visitDirectory(directory);
        System.out.println("Total size of the file system: " + totalSize + " MB");
    }
}
