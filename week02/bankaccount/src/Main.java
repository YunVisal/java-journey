public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("John Doe");
        System.out.println(bankAccount1);

        deposit(bankAccount1, 10.0);
        System.out.println(bankAccount1.getBalance());

        deposit(bankAccount1, -20000);
        System.out.println(bankAccount1.getBalance());

        withdraw(bankAccount1, 1);
        System.out.println(bankAccount1.getBalance());

        withdraw(bankAccount1, -20);
        System.out.println(bankAccount1.getBalance());

        withdraw(bankAccount1, 10);
        System.out.println(bankAccount1.getBalance());

        withdraw(bankAccount1, 9);
        System.out.println(bankAccount1.getBalance());

        BankAccount bankAccount2 = new BankAccount("Bob");
        System.out.println(bankAccount2);

        BankAccount bankAccount3 = new BankAccount("Mary", 50);
        System.out.println(bankAccount3);
    }

    static void deposit(BankAccount bankAccount, double amount) {
        boolean isSuccess = bankAccount.deposit(amount);
        if (isSuccess) {
            System.out.println("Deposit success.");
        } else {
            System.out.println("Deposit fail.");
        }
    }

    static void withdraw(BankAccount bankAccount, double amount) {
        boolean isSuccess = bankAccount.withdraw(amount);
        if (isSuccess) {
            System.out.println("Withdraw success.");
        } else {
            System.out.println("Withdraw fail.");
        }
    }
}