public class Engineer extends Employee {
    private static final double BASE_SALARY_MULTIPLIER = 1.1;

    public Engineer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        double employeeBaseSalary = super.calculateSalary();
        return employeeBaseSalary * BASE_SALARY_MULTIPLIER;
    }
}
