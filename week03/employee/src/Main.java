public class Main {
    public static void main(String[] args) {
        Employee engineer = new Engineer("John", 2000);
        Employee manager = new Manager("Bob", 2000, 3);

        System.out.println("Name, Salary");
        System.out.printf("%s, %.2f%n", engineer.getName(), engineer.calculateSalary());
        System.out.printf("%s, %.2f%n", manager.getName(), manager.calculateSalary());

    }
}
