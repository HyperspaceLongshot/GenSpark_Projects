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
public static void guessGame(){
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

    // Boolean to keep game open
       // boolean gameOn = true;

    // Print greeting and ask name
    System.out.println("Hello, what is your name?");

    // Catch user input set to variable
    String name = userInput.nextLine();

    // Print response, number range and request player input
    System.out.printf("Well, it is a pleasure to meet you %s, I am thinking of a number between 1 and 20.%n",name);


            for (int i = tries; i < chances; i++){

                // Catch user input and store in variable
                int guess = Integer.parseInt(userInput.next());

                // if statement to check guess and return response
                if (guess == winNum){
                    // Proclaim winner and ask if they want to play again
                    System.out.printf("Wow, %s! You've got my number in %d guesses!\nWould you like to play again? Yes or No. %n", name, i + 1 );

                    // Catch user input for play again
                    String playAgainAns = userInput.next();

                    // if Statement to play again or not
                    if (playAgainAns.toUpperCase(Locale.ROOT).equals("YES")){
                        //gameOn = true;
                        guessGame();
                    }else if (playAgainAns.toUpperCase(Locale.ROOT).equals("NO")){
                        System.out.printf("Thank you %s for playing. Have a great day!%n",name);
                       // gameOn =false;
                    }
                // If guess is too low
                }else if (guess < winNum && i != chances -1){
                    System.out.printf("Hmm, %d is too low. Please guess again. %n",guess);
                    // If guess is too high
                } else if (guess > winNum){
                    System.out.printf("Hmm, %d is too high. Please guess again.%n",guess);
                }

            }

        System.out.printf("I am sorry you have used your %d chances.\nThe correct number was %d.\nWould you like to play again? Yes or no.%n",chances, winNum);

        // Catch user input for play again
        String playAgainAns = userInput.next();

        // if Statement to play again or not
        if (playAgainAns.equalsIgnoreCase("YES")){
            // gameOn = true;
            guessGame();
        }else if (playAgainAns.toUpperCase(Locale.ROOT).equals("NO")){
            System.out.printf("Thank you %s for playing. Have a great day!%n",name);
            // gameOn =false;


    }

}
}
