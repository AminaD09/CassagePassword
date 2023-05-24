

import java.util.List;

public class PasswordGuessingMethodFactory {
    public static PasswordGuessingMethod createBruteForceMethod(String methodType,List<String> combinations, String hashedPassword) {
        return new BruteForceMethod(combinations);
    }

    public static PasswordGuessingMethod createDictionaryMethod(String methodType,List<String> dictionary, String hashedPassword) {
        return new DictionaryMethod(dictionary);
    }
}



