//import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
public class BruteForceMethod implements PasswordGuessingMethod {
    private List<String> combinations;
    

    public BruteForceMethod(List<String> combinations) {
        this.combinations = combinations;
        
    }

    @Override
    public boolean guessPassword(String password) {
        for (String combination : combinations) { 

            if (combination.equals(password)) {
                return true;
            }
        }
        return false;
    }

}