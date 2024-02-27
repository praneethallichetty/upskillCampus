import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount for deposit. Please enter a positive amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount for withdrawal or insufficient funds.");
        }
    }

    // Method to check the account balance
    public void checkBalance() {
        System.out.println("Account Balance for " + accountHolder + ": $" + balance);
    }
}

public class BankingInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a BankAccount object
        BankAccount myAccount = new BankAccount("123456789", "John Doe", 1000.0);

        // Menu for Banking Operations
        int choice;
        do {
            System.out.println("\nBanking Operations Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawalAmount);
                    break;

                case 3:
                    myAccount.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting the Banking System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
