import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static String createFileContent(Scanner scanner) {
        StringBuilder builder = new StringBuilder();
        String content = "";
        while (!content.matches("^!q.*")) {
            content = scanner.nextLine();
            builder.append(content);
        }
        String result = builder.toString();
        return result.replaceAll("!q", "");
    }

    public static void createZipFiles(ZipOutputStream stream, Scanner scanner) throws IOException {
        String name = "";
        boolean isEnd = false;
        while (!isEnd) {
            System.out.print("File name: ");
            name = scanner.next();
            if (name.matches("^!Q.*")) {
                isEnd = true;
            } else {
                ZipEntry entry = new ZipEntry(name);
                stream.putNextEntry(entry);
                System.out.println("File content: ");
                String fileContent = createFileContent(scanner);
                stream.write(fileContent.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public static void main(String[] args) {
        try (ZipOutputStream stream = new ZipOutputStream(new FileOutputStream("output.zip"))) {
            Scanner scanner = new Scanner(System.in);
            createZipFiles(stream, scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
