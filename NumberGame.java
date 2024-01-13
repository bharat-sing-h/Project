import java.util.Random;
import java.util.Scanner;
public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int LimitOfAttempts = 20;
        int rounds = 0;
        int totalAttempts = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Game");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(100 - 1 + 1) + 1;

            System.out.println("\nNew round! Guess the number between 1 and 100");

            while (attempts < LimitOfAttempts) {
                System.out.print("Guess the number: ");
                int Guess = scanner.nextInt();
                attempts++;

                if (Guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (Guess < generatedNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                if (attempts == LimitOfAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
                }
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nGame over! You played " + rounds + " rounds. Your total score is " + totalAttempts + " attempts.");

        scanner.close();
    }
}