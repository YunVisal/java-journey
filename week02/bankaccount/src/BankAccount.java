public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BankAccount(String ownerName) {
        this(ownerName, 0);
    }

    public String describe() {
        return String.format("Account Owner: %s - Balance: %.2f", ownerName, balance);
    }
}