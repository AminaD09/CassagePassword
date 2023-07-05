import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class DictionaryMethod implements PasswordGuessingMethod {
    private List<String> dictionary;
    
    @Override
    public boolean guessPassword(String password) {
    
        boolean isPasswordCorrect = sendLoginRequest(password);

        for (String word : dictionary) {
            if (word.equals(password)) {
                return true;
            }
        }
        return false;
    }


}

     