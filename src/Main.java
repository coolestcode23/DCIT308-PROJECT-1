public class Main {
    public static void main(String[] args) {
        // Example usage
        PharmacyManagementSystem pharmacySystem = new PharmacyManagementSystem();

        Supplier supplier1 = new Supplier(1, "Supplier A", "123 Main St", "555-1234");
        Supplier supplier2 = new Supplier(2, "Supplier B", "456 Oak Rd", "555-5678");

        Drug drug1 = new Drug(22, "Weed", "A dangerous drug", 20.00, 2, 10, 50);
        Drug drug2 = new Drug(2, "Meth", "A dangerous drug", 20.00, 2, 10, 50);


        pharmacySystem.addDrug(drug1);
        pharmacySystem.addDrug(drug2);
        pharmacySystem.removeDrug("Weed");

       pharmacySystem.viewAllDrugs();
        }
};



