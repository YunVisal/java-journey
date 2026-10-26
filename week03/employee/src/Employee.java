public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base Salary must be greater than 0");
        }

        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
