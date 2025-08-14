package org.santhoshrao;
import java.util.Scanner;

public class WordFrequencyCounter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");   // asking user to enter a line of text
        String inputText = sc.nextLine();

        inputText = inputText.toLowerCase();  // making all text lower case for ignoring case

        // removing all punctuation by replacing with space
        inputText = inputText.replaceAll("[^a-z\\s]", " ");

        // splitting the input text into words by spaces
        String[] words = inputText.trim().split("\\s+");
        String[] uniqueWords = new String[words.length];  // creating arrays to store unique words and their counts
        int[] counts = new int[words.length];

        int uniqueCount = 0;
        for(int i = 0; i < words.length; i++){      // counting frequency of each word manually using for loop
            String word = words[i];
            boolean found = false;
            // check if current word is already seen
            for(int j = 0; j < uniqueCount; j++){
                if(uniqueWords[j].equals(word)){
                    counts[j] = counts[j] + 1; // increment count
                    found = true;
                    break;
                }
            }
            if (!found) {       // if current word not found before, add it to uniqueWords
                uniqueWords[uniqueCount] = word;
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        // showing word frequencies to user
        System.out.println("\nFrequency of each word is:");
        for(int i = 0; i < uniqueCount; i++){
            System.out.println(uniqueWords[i] + " : " + counts[i]);
        }
    }
}
