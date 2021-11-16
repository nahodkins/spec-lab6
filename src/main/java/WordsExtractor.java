import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsExtractor {

    private static final String WORDS_REGEX = "[a-zA-z]+";
    private static final String SPACE = " ";

    public static String extractWordsFromText(String text) {
        Pattern pattern = Pattern.compile(WORDS_REGEX);
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return String.join(SPACE, words);
    }
}
