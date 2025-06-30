import java.util.Random;
import java.util.Scanner;

public class videogame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        final int MAX_ATTEMPTS = 5;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;  // 1 to 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();  // clear the invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + numberToGuess);
            }

            roundsPlayed++;

            // Ask if player wants to continue
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();
    }
}
