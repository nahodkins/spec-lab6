import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String msg = IOHelper.readStringFromFile("file.txt");
        String text = WordsExtractor.extractWordsFromText(msg);
        IOHelper.writeStringToFile(text, "output.txt");
    }
}
