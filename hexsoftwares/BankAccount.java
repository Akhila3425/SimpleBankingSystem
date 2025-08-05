package bankmanagingsystem;
import java.util.Scanner;
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}

// Customer class
class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public void showDetails() {
        System.out.println("Customer: " + name);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    public BankAccount getAccount() {
        return account;
    }
}
public class BankSytem {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Bank Account Creation -----");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        Customer customer = new Customer(name, accNumber);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    customer.getAccount().deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    customer.getAccount().withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + customer.getAccount().getBalance());
                    break;
                case 4:
                    customer.showDetails();
                    break;
                case 5:
                    System.out.println("Thank you for using our banking system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    
            }
        }
    }
}


	