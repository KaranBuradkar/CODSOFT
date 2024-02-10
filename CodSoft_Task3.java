import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double Balance = 0d;

    BankAccount(double Amount) {
        Balance = Balance + Amount;
    }

    void depositing(double Amount) {
        Balance = Balance + Amount;
        System.out.println(Amount+" is deposited Successfully,Now Your Bank Balance Is " + Balance + "\n");
    }

    void withdrawing(double Amount) {
        if (Amount < Balance) {
            Balance = Balance - Amount;
            System.out.println(Amount+" is withdraw Successfully,Now Your Bank Balance Is " + Balance + "\n");
        } else
            System.out.println("Invalid Request. Insufficient Balance.");
    }

    void checkBalance() {
        System.out.println("\nYour Bank Balance Is " + Balance + "\n");
    }
}

class ATM {
    void Operations() {
        Scanner sc = new Scanner(System.in);
        double amount = 0;

        try {
            System.out.print("Enter Deposit Amount: ");
            double DepositAmount = sc.nextDouble();
            BankAccount account = new BankAccount(DepositAmount);

            do {
                System.out.println("Choose an Option.");
                System.out.println("1. Add Money\n2. Withdraw Money\n3. Check Bank Balance\n4. Exit");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("\nEnter Amount: ");
                    amount = sc.nextDouble();
                    account.depositing(amount);
                } else if (choice == 2) {
                    System.out.print("\nEnter Amount: ");
                    amount = sc.nextDouble();
                    account.withdrawing(amount);
                } else if (choice == 3) {
                    account.checkBalance();
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("\nInvalid choice.\n");
                }

            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            sc.close();
        }
    }
}

public class CodSoft_Task3 {
    public static void main(String[] args) {
        ATM A = new ATM();
        A.Operations();
    }
}
