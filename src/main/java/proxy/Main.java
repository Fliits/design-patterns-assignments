package proxy;

public class Main {
    public static void main(String[] args) {
        AccessControlService accessControlService = new AccessControlService();
        Library library = new Library();

        Document document1 = new Document("Content of Document 1", "Document1", "2023-01-01");
        library.addDocument(document1.getName(), document1);
        Document document2 = new Document("Content of Document 2", "Document2", "2023-02-01");
        library.addDocument(document2.getName(), document2);
        Document fakeDocument = new Document("-", "Document1", "0");
        library.addDocument(fakeDocument.getName(), fakeDocument);

        User user1 = new User("user1");
        User user2 = new User("user2");
        accessControlService.addUser(user1);
        //accessControlService.addUser(user2);

        // Check access for users to documents
        DocumentProxy document1Proxy = new DocumentProxy("Document1");
        document1Proxy.getSecureContent(library, "user1", accessControlService);
        document1Proxy.getSecureContent(library, "user2", accessControlService);

        DocumentProxy document2Proxy = new DocumentProxy("Document2");
        document2Proxy.getSecureContent(library, "user1", accessControlService);
        document2Proxy.getSecureContent(library, "user2", accessControlService);

        DocumentProxy fakeDocumentProxy = new DocumentProxy("Document");
        fakeDocumentProxy.getSecureContent(library, "user1", accessControlService);

    }
}
