public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance) {
        if(balance < 0) {
            throw new IllegalArgumentException("Balance must not be negative value");
        }
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BankAccount(String ownerName) {
        this(ownerName, 0);
    }

    public String describe() {
        return String.format("Account Owner: %s - Balance: %.2f", ownerName, balance);
    }

    public double getBalance() {
        return balance;
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