package visitor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a sample file system
        Directory root = new Directory("root", new ArrayList<>());
        File file1 = new File("file1.txt", 200);
        File file2 = new File("file2.doc", 100);
        Directory subDir = new Directory("subdir", new ArrayList<>());
        File file3 = new File("file3.txt", 300);

        root.addElement(file1);
        root.addElement(file2);
        root.addElement(subDir);
        subDir.addElement(file3);

        // Create a SearchVisitor and search for .txt files
        SearchVisitor searchVisitor = new SearchVisitor();
        searchVisitor.searchByFileExtension(".txt", root);

        // Create a SizeCalculatorVisitor and calculate the total size of the file system
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        sizeCalculatorVisitor.calculateTotalSize(root);
    }
}
