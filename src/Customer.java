import java.util.TreeSet;

// Customer class
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private TreeSet<Purchase> purchaseHistory;

    public Customer(int customerId, String customerName, String customerAddress, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.purchaseHistory = new TreeSet<>((p1, p2) -> p1.getPurchaseDateTime().compareTo(p2.getPurchaseDateTime()));
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public TreeSet<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addPurchase(Purchase purchase) {
        purchaseHistory.add(purchase);
    }
}
