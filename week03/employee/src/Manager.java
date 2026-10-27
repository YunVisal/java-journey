public class Manager extends Employee {
    private static final double BASE_SALARY_MULTIPLIER = 1.2;
    private static final double PER_REPORT_BONUS = 500;

    private int totalDirectReports;

    public Manager(String name, double baseSalary, int totalDirectReports) {
        if (totalDirectReports < 0) {
            throw new IllegalArgumentException("Total Direct Reports should not be negative value");
        }

        super(name, baseSalary);
        this.totalDirectReports = totalDirectReports;
    }

    @Override
    public double calculateSalary() {
        double employeeBaseSalary = super.calculateSalary();
        double managerBaseSalary = employeeBaseSalary * BASE_SALARY_MULTIPLIER;
        double directReportAddon = totalDirectReports * PER_REPORT_BONUS;
        return managerBaseSalary + directReportAddon;
    }
}
