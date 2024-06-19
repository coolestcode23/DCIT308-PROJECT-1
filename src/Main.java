import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Example usage
        PharmacyManagementSystem pharmacySystem = new PharmacyManagementSystem();

        Supplier supplier1 = new Supplier(1, "Supplier A", "123 Main St", "555-1234");
        Supplier supplier2 = new Supplier(2, "Supplier B", "456 Oak Rd", "555-5678");

        Drug drug1 = new Drug(22, "Weed", "A dangerous drug", 20.00, 2, 10, 50);
        Drug drug2 = new Drug(2, "Meth", "A dangerous drug", 20.00, 2, 10, 50);

        Customer customer1 = new Customer(1, "Jonathan", "Okponglo", "0592024394");



        System.out.println(drug1.getPurchaseHistory());

        pharmacySystem.addDrug(drug1);

        }
};



