import java.time.LocalDateTime;

// Purchase class
public class Purchase implements Comparable<Purchase> {
    private int purchaseId;
    private Drug drug;
    private Customer customer;
    private int quantity;
    private double totalAmount;
    private LocalDateTime purchaseDateTime;

    public Purchase(int purchaseId, Drug drug, Customer customer, int quantity, double totalAmount, LocalDateTime purchaseDateTime) {
        this.purchaseId = purchaseId;
        this.drug = drug;
        this.customer = customer;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.purchaseDateTime = purchaseDateTime;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public Drug getDrug() {
        return drug;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    @Override
    public int compareTo(Purchase other) {
        return this.purchaseDateTime.compareTo(other.getPurchaseDateTime());
    }
}
