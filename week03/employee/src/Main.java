public class Main {
    public static void main(String[] args) {
        Employee engineer = new Engineer("John", 1800);
        Employee manager = new Manager("Bob", 3000);

        System.out.println("Name, Base Salary");
        System.out.printf("%s, %.2f%n", engineer.getName(), engineer.getBaseSalary());
        System.out.printf("%s, %.2f%n", manager.getName(), manager.getBaseSalary());
    }
}
