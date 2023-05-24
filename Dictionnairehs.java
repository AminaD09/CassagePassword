

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Dictionnairehs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le mot de passe : ");
        String motdepasse = scanner.nextLine();


        long tempsdebut = System.currentTimeMillis();
        long tempsfin = System.currentTimeMillis();
        long tempsexecution = tempsfin - tempsdebut;


        try {
            File dictionaryFile = new File("MDP.txt"); // Chemin du fichier contenant le dictionnaire
            Scanner dictionaryScanner = new Scanner(dictionaryFile);

            while (dictionaryScanner.hasNextLine()) {
                String motdevine = dictionaryScanner.nextLine().trim();

                if (hash(motdevine).equals(hash(motdepasse))) {
                    System.out.println("Mot de passe deviné avec succes: " + motdevine);
                    break;
                }/*else{
                    System.out.println("Hash different");
                    break;
                }*/
            }

            System.out.println("temps d'execution :" + tempsexecution);

            dictionaryScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier du dictionnaire non trouvé.");
        }

        scanner.close();

        
    }

    

    public static String hash(String motdevine) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(motdevine.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erreur : Algorithme de hachage non disponible.");
            return null;
        }
    }
}