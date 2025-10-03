public class ReportGenerator {
    public void generateSalesReport(String title, List<Double> sales) {
        generateReport(title, sales, "Sale", "Total Sales", "Average Sale");
    }

    public void generateInventoryReport(String title, List<Integer> inventory) {
        generateReport(title, inventory, "Item", "Total Items", "Average Item");
    }

    private void generateReport(String title, List<? extends Number> items, String itemLabel, String totalLabel, String averageLabel) {
        System.out.println("Report: " + title);
        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            System.out.println(itemLabel + " #" + (i + 1) + ": " + items.get(i));
            sum += items.get(i).doubleValue();
        }
        double avg = sum / items.size();
        System.out.println(totalLabel + ": " + sum);
        System.out.println(averageLabel + ": " + avg);
    }
}