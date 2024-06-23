package org.school.pharmacyui.models;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_phone")
    private String supplierPhone;

    public Supplier(int supplierId, String supplierName, String supplierAddress, String supplierPhone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
    }

    // required by hibernate
    public Supplier() {
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
