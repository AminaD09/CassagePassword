import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordGuessing {
    public static void main(String[] args) {
       

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le mot de passe :");
        String password = scanner.nextLine();

        


        //Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez la méthode de cassage de mot de passe qui vous convient :");
        System.out.println("1. Brute Force");
        System.out.println("2. Par dictionnaire");
        //System.out.println("3. BruteForce avec hash");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Pour vider le tampon

        PasswordGuessingMethod method;
        if (choice == 1) {
            method = new BruteForceMethod(generateCombinations());
        } else if (choice == 2) {
            List<String> dictionary = loadDictionary("C:/Users/bmd-tech/Documents/DIC_1/MDP.txt");
            method = PasswordGuessingMethodFactory.createDictionaryMethod("dictionary",  dictionary, password);
                                }



        
        




else {
            System.out.println("Choix invalide.");
            return;
        }

        if (method != null) {
            boolean passwordGuessed = method.guessPassword(password);
            if (passwordGuessed) {
                System.out.println("Mot de passe deviné avec succès !");

                System.out.println("Le mot de passe deviné est : " + password);
                
                


            // Avant l'exécution de la méthode de devinette
long startTime = System.currentTimeMillis();

// Exécution de la méthode de devinette
boolean PasswordGuessing = method.guessPassword(password);

// Après l'exécution de la méthode de devinette
long endTime = System.currentTimeMillis();

// Calcul de la durée en millisecondes
long duration = endTime - startTime;

// Affichage de la durée
System.out.println("Temps écoulé : " + duration + " millisecondes.");





            } else {
                System.out.println("Mot de passe non deviné.");
            }
        } else {
            System.out.println("Type de méthode invalide.");
        }
    }

    private static List<String> loadDictionary(String filePath) {
        List<String> dictionary = new ArrayList<>();
           

        try {
            dictionary = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du dictionnaire : " + e.getMessage());
        }
        // Charger les mots de passe depuis le fichier
        // Ajouter chaque mot de passe à la liste

        return dictionary;
    }

    private static List<String> generateCombinations() {
        List<String> combinations = new ArrayList<>();
        String characters = "abcdefghijklmnopqrstuvwxyz";

        for (int length = 1; length <= 4; length++) {
            generateCombinationsRecursive("", characters, length, combinations);
        }

        return combinations;
    }

    private static void generateCombinationsRecursive(String currentCombination, String characters, int length, List<String> combinations) {
        if (currentCombination.length() == length) {
            combinations.add(currentCombination);
        } else  if (currentCombination.length() < length) {
            for (int i = 0; i < characters.length(); i++) {
                char character = characters.charAt(i);
                generateCombinationsRecursive(currentCombination + character, characters, length, combinations);
            }
        }
    } 





}
