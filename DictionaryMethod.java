import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class DictionaryMethod implements PasswordGuessingMethod {
    private List<String> dictionary;
    //private String hashedPassword;
    private static final String LOGIN_URL = "http://localhost/";

    public DictionaryMethod(List<String> dictionary) {
        this.dictionary = dictionary;
        //this.hashedPassword = hashedPassword;
    } 

    
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




    private boolean sendLoginRequest(String password) {
        String username = "amina";
        try {
            URL url = new URL(LOGIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Parameters for the request
            String postData = "password=" + URLEncoder.encode(password, "UTF-8");
            connection.getOutputStream().write(postData.getBytes(StandardCharsets.UTF_8));

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Analyze the response from the login page to determine if the password is correct
                // For example, you can read the response and check if it contains certain text
                String response = readResponse(connection);
                return response.contains("Password correct"); // Modify this condition based on the actual response

            } else {
                // Request failed
                return false;
            }

        } catch (IOException e) {
            // Error handling for sending the request
            e.printStackTrace();
            return false;
        }
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        return response.toString();
    }



}

     