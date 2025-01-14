import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        getGuessedNumber();
    }


    public static int getGuessedNumber() {
        Scanner userGuess = new Scanner(System.in);
        System.out.println("Guess the Number:");
        int guessedNumber = userGuess.nextInt();
        return guessedNumber;
    }
}
