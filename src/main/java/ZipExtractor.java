import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {

    private static void createZipEntry(ZipEntry entry, ZipInputStream stream) throws IOException {
        if (entry.isDirectory()) {
            File file = new File(entry.getName());
            file.mkdirs();
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(entry.getName()))){
                int content;
                while ((content = stream.read()) > 0) {
                    writer.write(content);
                }
            }
        }
    }

    public static void extractFilesFromZip(String zipPath) {
        try (ZipInputStream stream = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry nextEntry;
            while ((nextEntry = stream.getNextEntry()) != null) {
                createZipEntry(nextEntry, stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
