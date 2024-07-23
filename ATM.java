package codsoft;

import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAutomated Teller Machine");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawCash();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);
    }

    private void withdrawCash() {
        Scanner scanner = new Scanner(System.in);
        double amount;

        do {
            System.out.print("Enter amount to withdraw (positive value): ");
            amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } while (amount <= 0);

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Please collect your cash.");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    private void depositCash() {
        Scanner scanner = new Scanner(System.in);
        double amount;

        do {
            System.out.print("Enter amount to deposit (positive value): ");
            amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } while (amount <= 0);

        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.run();
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
