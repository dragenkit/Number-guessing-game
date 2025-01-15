import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        generateTargetNumber();
        promptUserGuess();
    }

    // lets the player choose his guessed number
    public static int promptUserGuess() {
        Scanner userGuess = new Scanner(System.in);
        System.out.println("Guess the Number:");
        int guessedNumber = userGuess.nextInt();
        return guessedNumber;
    }
        // Returns a random number from 1 to 100
    public static int generateTargetNumber() {
            int targetNumber = (int)(Math.random() * 101);
            System.out.println(targetNumber);
            return targetNumber;
    }
}
