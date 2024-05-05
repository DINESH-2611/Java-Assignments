package MultiThreading;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader extends Thread {
    private final String fileUrl;
    private final String destinationFile;
    private volatile boolean interrupted = false;

    public FileDownloader(String fileUrl, String destinationFile) {
        this.fileUrl = fileUrl;
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try (InputStream inputStream = new URL(fileUrl).openStream();
             FileOutputStream outputStream = new FileOutputStream(destinationFile);
        ) {
            byte[] buffer = new byte[1024];
            long fileSize = getFileSize(fileUrl);
            long downloadedSize = 0;
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                if (interrupted) {
                    System.out.println("Download interrupted.");
                    return;
                }
                outputStream.write(buffer, 0, bytesRead);
                downloadedSize += bytesRead;
                System.out.printf("Downloaded %.2f%%\n", (downloadedSize * 100.0) / fileSize);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Download complete.");
    }


    private long getFileSize(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");
        return conn.getContentLengthLong();
    }

    public void interruptDownload() {
        interrupted = true;
    }

    public static void main(String[] args) {
        String fileUrl = "https://www.iitk.ac.in/esc101/share/downloads/javanotes5.pdf";
        String destinationFile = "src/MultiThreading/downloaded_file.pdf";

        FileDownloader downloader = new FileDownloader(fileUrl, destinationFile);
        downloader.start();

        // Simulate interruption after 5 seconds
        try {
            Thread.sleep(5000);
//            downloader.interruptDownload();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

