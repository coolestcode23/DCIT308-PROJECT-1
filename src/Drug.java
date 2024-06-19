import java.util.LinkedList;
import java.util.TreeSet;

// Drug class
public class Drug implements Comparable<Drug> {
    private int drugId;
    private String drugName;
    private String drugDescription;
    private double drugPrice;
    private int drugQuantity;
    private int minStockLevel;
    private int maxStockLevel;
    private LinkedList<Supplier> suppliers;
    private TreeSet<Purchase> purchaseHistory;

    public Drug(int drugId, String drugName, String drugDescription, double drugPrice, int drugQuantity, int minStockLevel, int maxStockLevel) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugDescription = drugDescription;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.minStockLevel = minStockLevel;
        this.maxStockLevel = maxStockLevel;
        this.suppliers = new LinkedList<>();
        this.purchaseHistory = new TreeSet<>();
    }

    public int getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }

    public int getMaxStockLevel() {
        return maxStockLevel;
    }

    public LinkedList<Supplier> getSuppliers() {
        return suppliers;
    }

    public TreeSet<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public Supplier searchSupplier(String supplierName, String address, String phoneNumber) {
        for(Supplier s: suppliers) {
            if(s.getSupplierName().equals(supplierName) || s.getSupplierAddress().equals(address) || s.getSupplierPhone().equals(phoneNumber)) {
                return s;
            }
        }
        return null;
    }

    public void addPurchase(Purchase purchase) {
        purchaseHistory.add(purchase);
    }

    public String toString() {
        return drugId + ": " + drugName;
    }

    @Override
    public int compareTo(Drug other) {
        return this.drugName.compareTo(other.getDrugName());
    }
}