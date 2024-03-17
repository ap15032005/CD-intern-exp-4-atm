import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; 
        }
        return false;
    }
}

public class atm {
    private BankAccount account;

    public atm(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    if (account.withdraw(amount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        atm atm = new atm(account);
        atm.run();
    }
}
