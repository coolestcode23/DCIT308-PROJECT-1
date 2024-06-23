package org.school.pharmacyui;


import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.school.pharmacyui.models.Customer;
import org.school.pharmacyui.models.Drug;
import javafx.scene.control.TableView;
import org.school.pharmacyui.models.Purchase;
import org.school.pharmacyui.models.Supplier;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    private MainApplication mainApp;

    private List<Drug> drugs;
    private List<Purchase> purchases;
    private List<Customer> customers;
    private List<Supplier> suppliers;

    private List<Supplier> selectedSuppliers = new LinkedList<>();

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        Utils.initializeDrugsTable(drugs, drugsTable, mainApp);
        Utils.initializeCustomersTable(customers, customersTable, mainApp);
    }

    public void loadDrugDetails(int drugId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             Drug drug = session.get(Drug.class, drugId);

            nameLabel.setText(drug.getDrugName());
            descriptionLabel.setText(drug.getDrugDescription());
            priceLabel.setText(String.valueOf(drug.getDrugPrice()));
            quantityLabel.setText(String.valueOf(drug.getDrugQuantity()));
            minStockLabel.setText(String.valueOf(drug.getMinStockLevel()));
            maxStockLabel.setText(String.valueOf(drug.getMaxStockLevel()));

            List<Supplier> sups = drug.getSuppliers();
            Utils.initializeSuppliersTable(sups, suppliersTable);
        }
    }

    public void loadCustomerDetails(int customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Customer customer = session.get(Customer.class, customerId);

            nameLabel.setText(customer.getCustomerName());
            addressLabel.setText(customer.getCustomerAddress());
            phoneLabel.setText(customer.getCustomerPhone());

            List<Purchase> ps = customer.getPurchaseHistory().stream().collect(Collectors.toList());
            Utils.initializePurchasesTable(ps, purchasesTable);
        }
    }


    @FXML
    public void goToAddDrugScreen() throws IOException {
       mainApp.navigate(Utils.Page.ADD_DRUGS);
    }

    @FXML
    public void goToDrugsScreen() throws IOException {
        mainApp.navigate(Utils.Page.DRUGS);
    }

    @FXML
    public void goToPurchasesScreen() throws IOException {
        mainApp.navigate(Utils.Page.PURCHASES);
    }

    @FXML
    public void goToCustomersScreen() throws IOException {
        mainApp.navigate(Utils.Page.CUSTOMERS);
    }

    @FXML
    public void goToSuppliersScreen() throws IOException {
        mainApp.navigate(Utils.Page.SUPPLIERS);
    }

    @FXML
    private TableView<Drug> drugsTable;

    @FXML
    private TableView<Purchase> purchasesTable;

    @FXML
    private TableView<Customer> customersTable;

    @FXML
    private TableView<Supplier> suppliersTable;

    @FXML
    private TextField search;

    @FXML
    private TextField name;

    @FXML
    private TextField description;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private TextField minStock;

    @FXML
    private TextField maxStock;

    @FXML
    private Label searchLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label minStockLabel;

    @FXML
    private Label maxStockLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private VBox supplierCheckboxes;


    @FXML
    public void addNewDrug() throws IOException {
        Drug newDrug = new Drug(drugs.size() + 1, name.getText(), description.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()), Integer.parseInt(minStock.getText()), Integer.parseInt(maxStock.getText()));
        if(!selectedSuppliers.isEmpty()) {
            for(Supplier s: selectedSuppliers) {
                newDrug.addSupplier(s);
            }
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newDrug);
            transaction.commit();
        }
        mainApp.navigate(Utils.Page.DRUGS);
    }

    @FXML
    public void onDrugSearch() {
        Utils.initializeDrugsTable(Utils.searchDrugs(search.getText(), drugs), drugsTable, mainApp);
    }

    @FXML
    public void onPurchaseSearch() {
        Utils.initializePurchasesTable(Utils.searchPurchases(search.getText(), purchases), purchasesTable);
    }

    @FXML
    public void onCustomerSearch() {
        Utils.initializeCustomersTable(Utils.searchCustomers(search.getText(), customers), customersTable, mainApp);
    }

    @FXML
    public void onSupplierSearch() {
        Utils.initializeSuppliersTable(Utils.searchSuppliers(search.getText(), suppliers), suppliersTable);
    }

    private void handleCheckBoxAction(CheckBox checkBox) {
        Supplier s = (Supplier) checkBox.getUserData();
        if (checkBox.isSelected()) {
            selectedSuppliers.add(s);
        } else {
            selectedSuppliers.remove(s);
        }
    }

    public void initialize() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            drugs = session.createQuery("from Drug", Drug.class).getResultList();
            suppliers = session.createQuery("from Supplier", Supplier.class).getResultList();
            customers = session.createQuery("from Customer", Customer.class).getResultList();
            purchases = session.createQuery("from Purchase", Purchase.class).getResultList();
        }

        Utils.initializeDrugsTable(drugs, drugsTable, mainApp);
        Utils.initializePurchasesTable(purchases, purchasesTable);
        Utils.initializeCustomersTable(customers, customersTable, mainApp);
        Utils.initializeSuppliersTable(suppliers, suppliersTable);

        if(supplierCheckboxes != null) {
            for(Supplier supplier: suppliers) {
                CheckBox checkBox = new CheckBox(supplier.getSupplierName());
                checkBox.setOnAction(event -> handleCheckBoxAction(checkBox));
                checkBox.setUserData(supplier);
                supplierCheckboxes.getChildren().add(checkBox);
            }
        }
    }
}