package org.school.pharmacyui.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
public class Purchase implements Comparable<Purchase> {
    @Id
    @Column(name = "purchase_id")
    private int purchaseId;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "purchase_quantity")
    private int quantity;

    @Column(name = "purchase_total_amount")
    private double totalAmount;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDateTime;

    public Purchase(int purchaseId, Drug drug, Customer customer, int quantity, LocalDateTime purchaseDateTime) {
        this.purchaseId = purchaseId;
        this.drug = drug;
        this.customer = customer;
        this.quantity = quantity;
        this.totalAmount = drug.getDrugPrice() * quantity;
        this.purchaseDateTime = purchaseDateTime;
    }

    // required by hibernate
    public Purchase() {
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

    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMM h:mm a", Locale.ENGLISH);
        return purchaseDateTime.format(formatter);
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    @Override
    public int compareTo(Purchase other) {
        int result = this.purchaseDateTime.compareTo(other.getPurchaseDateTime());

        // date and time is equal, compare the total amount
        if(result == 0) {
            result = Double.compare(this.totalAmount, other.totalAmount);
        }

        return result;
    }

    @Override
    public String toString() {
        return purchaseId + ": (" + drug.getDrugName() + ") - " + totalAmount;
    }
}
