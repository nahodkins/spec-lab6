import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessIO {

    private static final String READ_WRITE_OPTION = "rw";

    public static byte[] readBytes(String filePath) {
        byte[] bytes;
        try (RandomAccessFile file = new RandomAccessFile(filePath, READ_WRITE_OPTION)) {
            bytes = new byte[(int) file.length()];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = file.readByte();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return bytes;
    }

    public static void writeBytes(String filePath, byte[] bytes) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, READ_WRITE_OPTION)){
            for (byte b : bytes) {
                file.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void invertEvenBytes(String filePath) {
        byte[] bytes = readBytes(filePath);
        try (RandomAccessFile file = new RandomAccessFile(filePath, READ_WRITE_OPTION)) {
            for (int i = 0; i < bytes.length; i += 2) {
                file.seek(i);
                file.write(bytes[i] * -1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
