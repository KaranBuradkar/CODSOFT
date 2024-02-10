import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CodSoft_Task1 {
    public static void main(String[] args) {
        // Initialize variables
        int lowernumber = 1;
        int highernumber = 100;
        int playedRound = 0;
        int wonRounds = 0;
        int maxAttempts = 0;
        int playersNumber =0;
        boolean playagain = true;

        // Generate a random number between lowernumber and highenumber
        Random r = new Random();
        int generatedNumber = 1 + r.nextInt(highernumber - lowernumber + 1);
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome To Number Guessing Game.");

        do {
            try {
                // Display menu options
                System.out.println("\nSelect a Option.");
                System.out.println("1. Play \n2. Exit");
                System.out.print("Enter Your Choice : ");
                int choice = sc.nextInt();

                // If user chooses to exit, break out of the loop
                if (choice == 2) {
                    break;
                } else if (choice == 1) {
                    // Increment playedRound counter
                    playedRound++;
                    System.out.print("\nGuessed Number Between " + lowernumber + " - " + highernumber);
                    maxAttempts = 0;

                    // Allow the user to guess the number, with a maximum of 10 attempts
                    do {
                        try {
                            System.out.print("\nEnter Your Guessed Number : ");
                            playersNumber = sc.nextInt();
                            maxAttempts++;

                            if (playersNumber == generatedNumber) {
                                System.out.println("You Win! in " + maxAttempts + " Attempts.\n\n");
                                wonRounds++;
                            } else if (maxAttempts == 10) {
                                System.out.println("You used your all attempts.\nYou lose this game.\n");
                            } else {
                                if (playersNumber < generatedNumber) {
                                    System.out.println("Too Lower, Guess The Higher Number.");
                                } else if (playersNumber > generatedNumber) {
                                    System.out.println("Too Higher, Guess The Lower Number.");
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.nextLine(); // Consume the invalid input to prevent an infinite loop
                        }
                    } while (generatedNumber != playersNumber && maxAttempts < 10);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // Consume the invalid input to prevent an infinite loop
            }
        } while (playagain);

        sc.close();

        // Display game statistics
        if (playedRound > 0) {
            System.out.println("\n\nYou played " + playedRound + " Rounds.");
            System.out.println("You Won " + wonRounds + " Rounds and Lost " + (playedRound - wonRounds) + " Rounds");
        }

        System.out.println("\nSuccessfully You are Exited From Number Guessing Game, Thank You !!\n\n");
    }
}
