import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VigenereCipher {

    public byte[] encryptImage(byte[] file, String key) throws IOException {
        //what do the keys look like? numbers, chars?? uppercase, lowercase??
        char[] keyArr = key.toCharArray();
        byte[] result = new byte[file.length];

        for (int i = 0; i < file.length; i++) {
            result[i] = (byte) (file[i] + offset(keyArr[i % keyArr.length]));
        }
        return result;
    }

    public byte offset(char key) {
        return (byte)((Character.toLowerCase(key) - 97) % 26);
    }
    public byte[] decryptImage(byte[] file, String key) {
        char[] keyArr = key.toCharArray();
        byte[] result = new byte[file.length];

        for (int i = 0; i < file.length; i++) {
            result[i] = (byte) (file[i] - offset(keyArr[i % keyArr.length]));
        }
        return result;
    }

}
