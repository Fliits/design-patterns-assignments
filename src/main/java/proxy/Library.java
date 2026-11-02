package proxy;

import java.util.HashMap;

public class Library {

    private HashMap<String, IDocument> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addDocument(String name, IDocument document) {
        if (document.getCreationDate() == null || document.getContent() == null) {
            if (documents.containsKey(name)) {
                documents.put(name, document);
            }
        } else if (document.getCreationDate() != null && document.getContent() != null && !documents.containsKey(name)) {
            documents.put(name, document);
        } else {
            System.out.println("Document with name " + name + " already exists.");
        }
    }

    public IDocument getDocument(String name) {
        return documents.get(name);
    }
}
