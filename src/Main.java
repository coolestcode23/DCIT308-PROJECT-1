public class Main {
    public static void main(String[] args) {
        // Example usage
        PharmacyManagementSystem system = new PharmacyManagementSystem();

        Supplier supplier1 = new Supplier(1, "Supplier A", "123 Main St", "555-1234");
        Supplier supplier2 = new Supplier(2, "Supplier B", "456 Oak Rd", "555-5678");

        Drug drug1 = new Drug(22, "Weed", "A dangerous drug", 20.00, 2, 10, 50);

        System.out.println(drug1.getDrugDescription());


        }
};



