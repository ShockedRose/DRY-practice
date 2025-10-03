public class EmployeePayroll {
    private static final int MONTHLY_MULTIPLIER = 1;
    private static final int ANNUAL_MULTIPLIER = 12;

    public void processMonthlyPayroll(List<Employee> employees) {
        processPayroll(employees, MONTHLY_MULTIPLIER);
    }

    public void processAnnualPayroll(List<Employee> employees) {
        processPayroll(employees, ANNUAL_MULTIPLIER);
    }

    private void processPayroll(List<Employee> employees, int salaryMultiplier) {
        for (Employee e : employees) {
            double baseSalary = e.getBaseSalary() * salaryMultiplier;
            double bonus = salaryMultiplier == MONTHLY_MULTIPLIER ? e.getMonthlyBonus() : e.getAnnualBonus();
            double deductions = salaryMultiplier == MONTHLY_MULTIPLIER ? e.getMonthlyDeductions() : e.getAnnualDeductions();
            printPayrollSummary(e.getName(), baseSalary, bonus, deductions);
        }
    }

    private void printPayrollSummary(String employeeName, double baseSalary, double bonus, double deductions) {
        double total = baseSalary + bonus - deductions;
        System.out.println("Employee: " + employeeName);
        System.out.println("Base: " + baseSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Deductions: " + deductions);
        System.out.println("Total: " + total);
        System.out.println("----------");
    }
}