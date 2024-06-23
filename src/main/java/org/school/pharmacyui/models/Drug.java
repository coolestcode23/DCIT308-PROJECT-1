package org.school.pharmacyui.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

@Entity
public class Drug implements Comparable<Drug> {

    @Id
    @Column(name = "drug_id")
    private int drugId;

    @Column(name = "drug_name", nullable = false)
    private String drugName;

    @Column(name = "drug_description")
    private String drugDescription;

    @Column(name = "drug_price")
    private double drugPrice;

    @Column(name = "drug_quantity")
    private int drugQuantity;

    @Column(name = "min_stock_level")
    private int minStockLevel;

    @Column(name = "max_stock_level")
    private int maxStockLevel;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Supplier> suppliers = new LinkedList<>();

    // required by hibernate
    public Drug() {
    }

    // Constructor
    public Drug(int drugId, String drugName, String drugDescription, double drugPrice, int drugQuantity, int minStockLevel, int maxStockLevel) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.minStockLevel = minStockLevel;
        this.maxStockLevel = maxStockLevel;
    }

    // Getters and setters
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

    public void setDrugDescription(String drugDescription) {
        this.drugDescription = drugDescription;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }

    public void setMinStockLevel(int minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public int getMaxStockLevel() {
        return maxStockLevel;
    }

    public void setMaxStockLevel(int maxStockLevel) {
        this.maxStockLevel = maxStockLevel;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(LinkedList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    // Methods
    public TreeSet<Purchase> getPurchaseHistory(ArrayList<Purchase> allPurchases) {
        TreeSet<Purchase> purchaseHistory = new TreeSet<>();
        for (Purchase purchase : allPurchases) {
            if (purchase.getDrug().getDrugId() == drugId) {
                purchaseHistory.add(purchase);
            }
        }
        return purchaseHistory;
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public Supplier searchSupplier(String supplierName, String address, String phoneNumber) {
        for (Supplier s : suppliers) {
            if (s.getSupplierName().equals(supplierName) || s.getSupplierAddress().equals(address) || s.getSupplierPhone().equals(phoneNumber)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return drugId + ": " + drugName;
    }

    @Override
    public int compareTo(Drug other) {
        return this.drugName.compareTo(other.getDrugName());
    }
}