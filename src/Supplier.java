// Supplier class
public class Supplier {
    private int supplierId;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;

    public Supplier(int supplierId, String supplierName, String supplierAddress, String supplierPhone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }
}
