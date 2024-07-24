package codsoft;

import java.util.Scanner;
//Define the class with ATM name.
public class ATM3 {
// we should have bank account private.
    private BankAccount account;

    public ATM3(BankAccount account) {
        this.account = account;
    }
 // let us take the choice input from user.
    public void run() {
        Scanner a = new Scanner(System.in);
        int ch;
// give the choices to user.
        do {
            System.out.println("\nAutomated Teller Machine");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            ch = a.nextInt();

            switch (ch) {
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
        } while (ch != 4);
    }
// for taking cash withdraw.
    private void withdrawCash() {
        Scanner a = new Scanner(System.in);
        double amount;

        do {
            System.out.print("Enter amount to withdraw (positive value): ");
            amount = a.nextDouble();

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
// for deposit cash.
    private void depositCash() {
        Scanner a = new Scanner(System.in);
        double amount;

        do {
            System.out.print("Enter amount to deposit (positive value): ");
            amount = a.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } while (amount <= 0);

        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: " + account.getBalance());
    }
 // for checking the current balance in account.
    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
// main class to call all the functions.
    public static void main(String[] args) {
// we should have some initial ammount fixed deposited in the account as rs.1000.00    	
        BankAccount account = new BankAccount(1000.00); 
        ATM3 atm = new ATM3(account);
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
        balance = balance - amount;
        return true;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }
}