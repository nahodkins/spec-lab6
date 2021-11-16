public class HashCoder {

    public static Integer hashString(String str) {
        int hash = 0;
        for (byte b : str.getBytes()) {
            hash = hash * 5 + b + 7;
        }
        return hash;
    }
}
