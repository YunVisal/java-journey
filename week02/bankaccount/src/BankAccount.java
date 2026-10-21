public class BankAccount {
    private static int bankAccountNextNumber = 1001;

    private String ownerName;
    private double balance;
    private int bankAccountNumber;

    public BankAccount(String ownerName, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must not be negative value");
        }
        this.ownerName = ownerName;
        this.balance = balance;

        this.bankAccountNumber = bankAccountNextNumber;
        bankAccountNextNumber += 1;
    }

    public BankAccount(String ownerName) {
        this(ownerName, 0);
    }

    @Override
    public String toString() {
        return String.format("Account Number: %d, Account Owner: %s, Balance: %.2f", bankAccountNumber, ownerName, balance);
    }

    public double getBalance() {
        return balance;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}