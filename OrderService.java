public class OrderService {
    public void processOnlineOrder(double total) {
        processOrder(total, "online");
    }

    public void processInStoreOrder(double total) {
        processOrder(total, "in-store");
    }

    private void processOrder(double total, String orderType) {
        if (total < 0) {
            System.out.println("Total cannot be negative");
        } else if (total == 0) {
            System.out.println("Order total is zero");
        } else {
            System.out.println("Processing " + orderType + " order: " + total);
        }
    }
}