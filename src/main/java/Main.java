import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private static final String BYTES_FILE_NAME = "bytes.txt";
    private static final String DELIMITER = "+-------+-------+------+";
    private static final String OUTPUT_HEADER = DELIMITER + "\n| Index | Given | Read |\n" + DELIMITER;
    private static final String OUTPUT_TEMPLATE = "|  %2d   |  %2s   | %2s   |\n" + DELIMITER;


    private static byte[] initializeByteArray(int size) {
        byte[] bytes = new byte[size];
        for (int i = 0; i < size; i++) {
            bytes[i] = (byte) ((Math.random() * 4) + 1);
        }
        return bytes;
    }

    public static void main(String[] args) {
        byte[] bytes = initializeByteArray(64);
        RandomAccessIO.writeBytes(BYTES_FILE_NAME, bytes);
        RandomAccessIO.invertEvenBytes(BYTES_FILE_NAME);
        byte[] readBytes = RandomAccessIO.readBytes(BYTES_FILE_NAME);
        System.out.println(OUTPUT_HEADER);
        IntStream.range(0, bytes.length)
                .mapToObj(i -> String.format(OUTPUT_TEMPLATE, i, bytes[i], readBytes[i]))
                .forEach(System.out::println);
    }
}
