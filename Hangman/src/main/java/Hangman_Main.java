
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman_Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner to read file
        Scanner scan = new Scanner(new File("/Users/johnathanregan/Desktop/1000-most-common-words.txt"));
        // Scanner for user inputs
        Scanner playerKey = new Scanner(System.in);
        // ArrayList to hold words from text file
        ArrayList<String> gameWords = new ArrayList<>();
        // Put words in ArrayList
        while (scan.hasNext()){
            gameWords.add((scan.nextLine()));
        }
        // Generate random number to choose a word from index in list
        Random rand = new Random();
        String word = gameWords.get(rand.nextInt(gameWords.size()));
        //TODO String to test
        // Print out to test
        //System.out.println(word);

        // List of char to store and track player guesses
        List<Character> guesses = new ArrayList<>();
        // Initiate game with while looop and counter
        // Wrong guess tracking
        int incorrect = 0;
        while(true) {
            // board states here with conditionals
            if (incorrect == 0) {
                BoardState.boardState0();
            }else if (incorrect == 1){
             BoardState.boardState1();
            }else if (incorrect == 2){
                BoardState.boardState2();
            }else if (incorrect == 3){
                BoardState.boardState3();
            }else if (incorrect == 4){
                BoardState.boardState4();
            }else if (incorrect == 5){
                BoardState.boardState5();
            }else {
                BoardState.boardState6();
            }
            // Lose game condition and string
            if (incorrect >= 6){
                System.out.println("That's to bad.. killer.");
                break;
            }

            // Method to make word board and check for win
            wordLoop(word, guesses);
            // Method to get guesses and track if correct or lose
            if(!getPlayerGuess(playerKey, word, guesses)){
                incorrect++;
            }

            // If word guessed winna winna
            if(wordLoop(word, guesses)){
                System.out.println("You guessed the word! So you win!");
                break;
            }
//            System.out.println("Please enter your guess of the word!");
//            playerKey.nextLine();
//            if (playerKey.nextLine().equals(word)){
//                System.out.println("You win!");
//                break;
//
//            }else {
//                System.out.println("Incorrect... please try again.");
//            }

        }


    }

    private static boolean getPlayerGuess(Scanner playerKey, String word, List<Character> guesses) {
        System.out.println("Please guess a letter guess!");
        String letterGuess = playerKey.nextLine();
        guesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    private static boolean wordLoop(String word, List<Character> guesses) {
        int correct = 0;
        //TODO Change this loop to a stream
        for (int i = 0; i < word.length(); i++){
            if (guesses.contains(word.charAt(i))){
            System.out.print(word.charAt(i));
            correct++;
        }else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correct);
    }
}
