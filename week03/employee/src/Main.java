public class Main {
    public static void main(String[] args) {
        Employee engineer = new Engineer("John", 2000);
        Employee manager = new Manager("Bob", 2000, 3);
        Employee alice = new Employee("Alice", 1500);

        System.out.println("Name, Salary");
        Employee[] employees = new Employee[] { engineer, manager, alice };
        double totalPayroll = 0;
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            System.out.printf("%s, %.2f%n", employee.getName(), salary);
            totalPayroll += salary;
        }
        System.out.printf("Total payroll: %.2f%n", totalPayroll);
    }
}
