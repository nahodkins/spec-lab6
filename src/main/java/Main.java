public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Wrong number of arguments");
        } else {
            ZipExtractor.extractFilesFromZip(args[0]);
        }
    }
}
