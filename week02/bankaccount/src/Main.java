public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("John Doe");
        System.out.println(bankAccount1.describe());

        BankAccount bankAccount2 = new BankAccount("Mary Doe", 3.5);
        System.out.println(bankAccount2.describe());
    }
}