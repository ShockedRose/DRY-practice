public class EmployeePayroll {
    public void processMonthlyPayroll(List<Employee> employees) {
        for (Employee e : employees) {
            double baseSalary = e.getBaseSalary();
            double bonus = e.getMonthlyBonus();
            double deductions = e.getMonthlyDeductions();
            printPayrollSummary(e.getName(), baseSalary, bonus, deductions);
        }
    }

    public void processAnnualPayroll(List<Employee> employees) {
        for (Employee e : employees) {
            double baseSalary = e.getBaseSalary() * 12;
            double bonus = e.getAnnualBonus();
            double deductions = e.getAnnualDeductions();
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