package abstractclassandmethods;

abstract public class Document {
    private String documentName;
    private String size;
    public Document(String documentName, String size) {
        this.documentName = documentName;
        this.size = size;
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getSize() {
        return size;
    }
    public abstract void getDocumentDetails();
}
class PDFDocument extends Document{
    public PDFDocument(String documentname, String size) {
        super(documentname, size);
    }

    @Override
    public void getDocumentDetails() {
        System.out.println("Document name="+getDocumentName()+",Size="+getSize());
    }
}
class TextDocument extends Document{
    public TextDocument(String documentname, String size) {
        super(documentname, size);
    }
    public void getDocumentDetails() {
        System.out.println("Document name="+getDocumentName()+",Size="+getSize());
    }
}
class ImageDocument extends Document{
    public ImageDocument(String documentname, String size) {
        super(documentname, size);
    }
    public void getDocumentDetails() {
        System.out.println("Document name="+getDocumentName()+",Size="+getSize());
    }
}
class DocumentDriver{
    public static void main(String[] args) {
        Document document1=new PDFDocument("basic.pdf","1mb");
        Document document2=new TextDocument("demo.txt","75kb");
        Document document3=new ImageDocument("profile.img","50mb");
        document1.getDocumentDetails();
        document2.getDocumentDetails();
        document3.getDocumentDetails();
    }
}

