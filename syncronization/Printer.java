package syncronization;

public class Printer {
    public void printDocument(String documentName) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is printing: " + documentName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished printing: " + documentName);
        }
    }
}

class DocumentPrinter implements Runnable {
    private Printer printer;
    private String documentName;

    public DocumentPrinter(Printer printer, String documentName) {
        this.printer = printer;
        this.documentName = documentName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printer.printDocument(documentName + " - Page " + (i + 1));
        }
    }
}
class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread thread1 = new Thread(new DocumentPrinter(printer, "Document1"));
        Thread thread2 = new Thread(new DocumentPrinter(printer, "Document2"));
        Thread thread3 = new Thread(new DocumentPrinter(printer, "Document3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

