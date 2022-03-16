import java.util.Locale;
import java.util.Scanner;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Guess the Number game title
        System.out.println("******************************");
        System.out.println("       Guess the Number       ");
        System.out.println("******************************");
        // Call method to run game
        guessGame();
    }// End of main --

    // Method to run game
    public static void guessGame() {
        // Create Scanner to take user input
        Scanner userInput = new Scanner(System.in);
        // Random number generator object
        Random ranNum = new Random();

        // int For random range
        int winNum = 1 + ranNum.nextInt(21 - 1);

        // int for chances given
        int chances = 6;

        // int for guesses made
        int tries = 0;

        // Print greeting and ask name
        System.out.println("Hello, what is your name?");

        // Call method to Catch user input set to variable
        String name = getName(userInput);

        // Print response, number range and request player input
        System.out.printf("Well, it is a pleasure to meet you %s, I am thinking of a number between 1 and 20.%n", name);

        // For loop to allow play until chances run out
        for (int i = tries; i < chances; i++) {
            // Call method to Catch user input and store in variable
            int guess = getGuessMethod(userInput);

            // if statement to check guess and return response
            if (guess == winNum) {
                // Proclaim winner and ask if they want to play again
                System.out.printf("Wow, %s! You've got my number in %d guesses!\nWould you like to play again? Yes or No. %n", name, i + 1);

                // Catch user input for play again
                String playAgainAns = getPlayAgainAns(userInput);

                // if Statement to play again or not
                if (playAgainAns.equalsIgnoreCase("YES")) {
                    guessGame();
                } else if (playAgainAns.equalsIgnoreCase("NO")) {
                    System.out.printf("Thank you %s for playing. Have a great day!%n", name);
                }
                // If guess is too low
            } else if (guess < winNum && i != chances - 1) {
                System.out.printf("Hmm, %d is too low. Please guess again. %n", guess);
                // If guess is too high
            } else if (guess > winNum) {
                System.out.printf("Hmm, %d is too high. Please guess again.%n", guess);
            }

        }
        // Inform user of depleted chances ask if they want to play again
        System.out.printf("I am sorry you have used your %d chances.\nThe correct number was %d.\nWould you like to play again? Yes or no.%n", chances, winNum);

        //Call method to Catch user input for play again
        String playAgainAns = getPlayAgainAns(userInput);

        // if Statement to play again or not
        if (playAgainAns.equalsIgnoreCase("YES")) {
            guessGame();
        } else if (playAgainAns.equalsIgnoreCase("NO")) {
            System.out.printf("Thank you %s for playing. Have a great day!%n", name);


        }

    }


    // Method for gathering user int input
    public static int getGuessMethod(Scanner userInput) {
        int guess = 0;
        try {
            boolean isValidGuess = false;
            while (!isValidGuess) {
                guess = Integer.parseInt(userInput.next());
                isValidGuess = verifyGuessRange(guess);

            }

        } catch (Exception e) {
            return getGuessMethod(userInput); // => 35
        }
        return guess;
    }

    // Method to validate user input is with in int range for game (1 - 20)
    public static boolean verifyGuessRange(int guess) {
        if (guess <= 0 || guess > 20) {
            System.out.println("Oops, that is not a valid input.\nPlease guess a positive number from 1 to 20.");
            return false;
        }
        return true;
    }

    // Method for gathering user play again string input
    public static String getPlayAgainAns(Scanner userInput) {
        try {
            String playAgainAns = userInput.next();
            return playAgainAns;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // Method for gathering username input
    public static String getName(Scanner userInput) {
        try {
            String name = userInput.nextLine();
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
