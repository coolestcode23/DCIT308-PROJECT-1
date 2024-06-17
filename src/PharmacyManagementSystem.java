import java.util.LinkedList;

// Pharmacy Management System
public class PharmacyManagementSystem {
    private LinkedList<Drug> drugs;

    public PharmacyManagementSystem() {
        this.drugs = new LinkedList<>();
    }

    public void addDrug(Drug drug) {
        drugs.add(drug);
    }

    public void removeDrug(String name) {
        if(!drugs.isEmpty()) {
            drugs.removeIf(d -> d.getDrugName().equals(name));
        }
    }


    public Drug searchDrug(String drugName) {
        for (Drug drug : drugs) {
            if (drug.getDrugName().equalsIgnoreCase(drugName)) {
                return drug;
            }
        }
        return null;
    }

    public void viewAllDrugs() {
        for (Drug drug : drugs) {
            System.out.println("Drug ID: " + drug.getDrugId());
            System.out.println("Drug Name: " + drug.getDrugName());
            System.out.println("Drug Description: " + drug.getDrugDescription());
            System.out.println("Drug Price: " + drug.getDrugPrice());
            System.out.println("Drug Quantity: " + drug.getDrugQuantity());
            System.out.println("Suppliers:");
            for (Supplier supplier : drug.getSuppliers()) {
                System.out.println("- Supplier ID: " + supplier.getSupplierId());
                System.out.println("  Supplier Name: " + supplier.getSupplierName());
                System.out.println("  Supplier Address: " + supplier.getSupplierAddress());
                System.out.println("  Supplier Phone: " + supplier.getSupplierPhone());
            }
            System.out.println("Purchase History:");
            for (Purchase purchase : drug.getPurchaseHistory()) {
                System.out.println("- Purchase ID: " + purchase.getPurchaseId());
                System.out.println("  Customer: " + purchase.getCustomer().getCustomerName());
                System.out.println("  Quantity: " + purchase.getQuantity());
                System.out.println("  Total Amount: " + purchase.getTotalAmount());
                System.out.println("  Purchase Date: " + purchase.getPurchaseDateTime());
            }
            System.out.println();
        }
    }
}