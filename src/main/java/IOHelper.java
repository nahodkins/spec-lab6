import java.io.*;
import java.util.stream.Collectors;

public class IOHelper {

    public static String readStringFromFile(String pathToFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String text = reader.lines().collect(Collectors.joining("\n"));
        reader.close();
        return text;
    }

    public static void writeStringToFile(String src, String pathToFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile));
        writer.write(src);
        writer.close();
    }
}
