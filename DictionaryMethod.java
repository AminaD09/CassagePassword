import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DictionaryMethod implements PasswordGuessingMethod {
    private List<String> dictionary;
    private String hashedPassword;

    public DictionaryMethod(List<String> dictionary) {
        this.dictionary = dictionary;
        this.hashedPassword = hashedPassword;
    }

    @Override
    public boolean guessPassword(String password) {
        for (String word : dictionary) {
            if (word.equals(password)) {
                return true;
            }
        }
        return false;
    }




     private static String hashPassword(String password) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedHash);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return null;
}

     
//for (String word : dictionary) {
    //if (word.equals(hashedInputPassword)) {
        //return true;
    //}
//}
//return false;
//}


    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}