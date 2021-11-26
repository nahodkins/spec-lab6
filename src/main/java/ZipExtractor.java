import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {

    private static void createZipEntry(ZipEntry entry, ZipInputStream stream, String archiveFolder) throws IOException {
        String entrySavePath = archiveFolder + File.separator + entry.getName();
        if (entry.isDirectory()) {
            File file = new File(entrySavePath);
            file.mkdirs();
        } else {
            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter(entrySavePath))){
                int content;
                while ((content = stream.read()) > 0) {
                    writer.write(content);
                }
            }
        }
    }

    private static String createArchiveFolder(String zipPath) {
        File file = new File(zipPath);
        String name = file.getName().replaceAll(".zip", "");
        new File(name).mkdirs();
        return name;
    }

    public static void extractFilesFromZip(String zipPath) {
        String archiveFolder = createArchiveFolder(zipPath);
        try (ZipInputStream stream = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry nextEntry;
            while ((nextEntry = stream.getNextEntry()) != null) {
                createZipEntry(nextEntry, stream, archiveFolder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
