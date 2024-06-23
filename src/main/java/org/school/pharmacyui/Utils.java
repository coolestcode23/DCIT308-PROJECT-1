package org.school.pharmacyui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.school.pharmacyui.models.Customer;
import org.school.pharmacyui.models.Drug;
import org.school.pharmacyui.models.Purchase;
import org.school.pharmacyui.models.Supplier;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static enum Page {
        DRUGS,
        PURCHASES,
        SUPPLIERS,
        CUSTOMERS,
        ADD_DRUGS,
        DRUG_DETAILS,
    }

    public static String getPageViewName(Page page) {
        switch (page) {
            case ADD_DRUGS:
                return "add-drug-view.fxml";
            case PURCHASES:
                return "purchases-view.fxml";
            case CUSTOMERS:
                return "customers-view.fxml";
            case SUPPLIERS:
                return "suppliers-view.fxml";
            case DRUG_DETAILS:
                return "drug-details-view.fxml";
            default:
                return "main-view.fxml";
        }
    }

    public static void initializeDrugsTable(List<Drug> drugs, TableView<Drug> table, MainApplication mainApp) {
        if(table != null) {
            ObservableList<Drug> data = FXCollections.observableArrayList(drugs);

            TableColumn<Drug, String> drugIDCol = (TableColumn<Drug, String>) table.getColumns().get(0);
            drugIDCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDrugId())));

            TableColumn<Drug, String> drugNameCol = (TableColumn<Drug, String>) table.getColumns().get(1);
            drugNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrugName()));

            TableColumn<Drug, String> drugDescriptionCol = (TableColumn<Drug, String>) table.getColumns().get(2);
            drugDescriptionCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrugDescription()));

            TableColumn<Drug, String> drugPriceCol = (TableColumn<Drug, String>) table.getColumns().get(3);
            drugPriceCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDrugPrice())));

            TableColumn<Drug, String> drugQuantityCol = (TableColumn<Drug, String>) table.getColumns().get(4);
            drugQuantityCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDrugQuantity())));

            TableColumn<Drug, String> drugMinStockCol = (TableColumn<Drug, String>) table.getColumns().get(5);
            drugMinStockCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getMinStockLevel())));

            TableColumn<Drug, String> drugMaxStockCol = (TableColumn<Drug, String>) table.getColumns().get(6);
            drugMaxStockCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getMaxStockLevel())));

            table.setRowFactory(tv -> {
                TableRow<Drug> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (!row.isEmpty())) {
                        Drug drug = row.getItem();
                        try {
                            mainApp.navigate(Page.DRUG_DETAILS, drug.getDrugId());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                return row;
            });


            table.setItems(data);
        }
    }

    public static void initializePurchasesTable(List<Purchase> purchases, TableView<Purchase> table) {
        if (table != null) {
            table.setEditable(false);
            ObservableList<Purchase> data = FXCollections.observableArrayList(purchases);

            TableColumn<Purchase, String> col1 = (TableColumn<Purchase, String>) table.getColumns().get(0);
            col1.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPurchaseId())));

            TableColumn<Purchase, String> col2 = (TableColumn<Purchase, String>) table.getColumns().get(1);
            col2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDrug().getDrugName()));

            TableColumn<Purchase, String> col3 = (TableColumn<Purchase, String>) table.getColumns().get(2);
            col3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getCustomerName()));

            TableColumn<Purchase, String> col4 = (TableColumn<Purchase, String>) table.getColumns().get(3);
            col4.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getQuantity())));

            TableColumn<Purchase, String> col5 = (TableColumn<Purchase, String>) table.getColumns().get(4);
            col5.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalAmount())));

            TableColumn<Purchase, String> col6 = (TableColumn<Purchase, String>) table.getColumns().get(5);
            col6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormattedDateTime()));

            table.setItems(data);
        }
    }

    public static void initializeCustomersTable(List<Customer> customers, TableView<Customer> table) {
        if (table != null) {
            table.setEditable(false);
            ObservableList<Customer> data = FXCollections.observableArrayList(customers);

            TableColumn<Customer, String> col1 = (TableColumn<Customer, String>) table.getColumns().get(0);
            col1.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCustomerId())));

            TableColumn<Customer, String> col2 = (TableColumn<Customer, String>) table.getColumns().get(1);
            col2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerName()));

            TableColumn<Customer, String> col3 = (TableColumn<Customer, String>) table.getColumns().get(2);
            col3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerAddress()));

            TableColumn<Customer, String> col4 = (TableColumn<Customer, String>) table.getColumns().get(3);
            col4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerPhone()));

            table.setItems(data);
        }
    }

    public static void initializeSuppliersTable(List<Supplier> suppliers, TableView<Supplier> table) {
        if (table != null) {
            table.setEditable(false);
            ObservableList<Supplier> data = FXCollections.observableArrayList(suppliers);

            TableColumn<Supplier, String> col1 = (TableColumn<Supplier, String>) table.getColumns().get(0);
            col1.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSupplierId())));

            TableColumn<Supplier, String> col2 = (TableColumn<Supplier, String>) table.getColumns().get(1);
            col2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierName()));

            TableColumn<Supplier, String> col3 = (TableColumn<Supplier, String>) table.getColumns().get(2);
            col3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierAddress()));

            TableColumn<Supplier, String> col4 = (TableColumn<Supplier, String>) table.getColumns().get(3);
            col4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSupplierPhone()));

            table.setItems(data);
        }
    }

    public static List<Drug> searchDrugs(String search, List<Drug> drugs) {
        LinkedList<Drug> result = new LinkedList<>();

        for(Drug drug: drugs) {
            if(drug.getDrugName().toLowerCase().contains(search.toLowerCase())) {
                result.add(drug);
            }
        }

        return result;
    }

    public static List<Purchase> searchPurchases(String search, List<Purchase> purchases) {
        LinkedList<Purchase> result = new LinkedList<>();

        for(Purchase purchase: purchases) {
            if(purchase.getDrug().getDrugName().toLowerCase().contains(search.toLowerCase()) || purchase.getCustomer().getCustomerName().toLowerCase().contains(search.toLowerCase())) {
                result.add(purchase);
            }
        }

        return result;
    }

    public static List<Customer> searchCustomers(String search, List<Customer> customers) {
        LinkedList<Customer> result = new LinkedList<>();

        for(Customer customer: customers) {
            if(customer.getCustomerName().toLowerCase().contains(search.toLowerCase())) {
                result.add(customer);
            }
        }

        return result;
    }

    public static List<Supplier> searchSuppliers(String search, List<Supplier> suppliers) {
        LinkedList<Supplier> result = new LinkedList<>();

        for(Supplier supplier: suppliers) {
            if(supplier.getSupplierName().toLowerCase().contains(search.toLowerCase()) || supplier.getSupplierAddress().toLowerCase().contains(search.toLowerCase())) {
                result.add(supplier);
            }
        }

        return result;
    }

}
