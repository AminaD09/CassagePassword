
//import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
public class BruteForceMethod implements PasswordGuessingMethod {
    private List<String> combinations;
    private String hashedPassword;

    public BruteForceMethod(List<String> combinations) {
        this.combinations = combinations;
        //this.hashedPassword = hashedPassword;
    }

    @Override
    public boolean guessPassword(String password) {
        for (String combination : combinations) { 


            //String hashedCombination = hashPassword(combination);
            //if (hashedCombination.equals(hashedPassword)) {
                //System.out.println("le hash est" + hashedPassword);
                //return true;
            //}


            if (combination.equals(password)) {
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
