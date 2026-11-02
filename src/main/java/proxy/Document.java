package proxy;

public class Document implements IDocument{
    private String content;
    private String name;
    private String creationDate;

    public Document(String content, String name, String creationDate) {
        this.content = content;
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }
}
