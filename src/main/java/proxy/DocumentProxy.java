package proxy;

public class DocumentProxy implements IDocument{
    public String documentName;

    public DocumentProxy(String documentName) {
        this.documentName = documentName;
    }

    public IDocument getSecureContent(Library library, String username, AccessControlService accessControlService) {
        // Implementation to retrieve the document content based on the name

        if (library.getDocument(documentName) != null) {
            if (accessControlService.isAllowed(username, documentName)) {
            System.out.println("Access granted for user: " + username + " to document: " + documentName);
            return library.getDocument(documentName);
            } else {
                System.out.println("Access denied for user: " + username + " to document: " + documentName);
            }
        } else {
            System.out.println("Document not found: " + documentName);
        }
        return null; // Placeholder return statement
    }

    public String getName() {
        return documentName;
    }

    public String getCreationDate() {
        return null;
    }

    public String getContent() {
        return null;
    }
}
