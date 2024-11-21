import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HashTableOfWords {
    public static void main(String[] args) {
        HashSet<String> wordHashTable = new HashSet<>();

        try {
            // Load the file
            File file = new File("1000-most-common-words.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim();
                wordHashTable.add(word.toLowerCase()); 
            }

            fileScanner.close();
            System.out.println("Words loaded into the hash table...");

            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a word to search: ");
            String wordToSearch = userInput.nextLine().trim().toLowerCase();

            if (wordHashTable.contains(wordToSearch)) {
                System.out.println("Yes, the word is in the hash table.");
            } else {
                System.out.println("No, the word is not in the hash table.");
            }

            userInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please make sure the file is in the correct location.");
        }
    }
}