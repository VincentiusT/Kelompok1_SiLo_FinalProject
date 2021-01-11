package SiLO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author feral
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int invoiceNumber;
    private int PONumber;
    private String supplierName;
    Date orderDate = new Date();
    Date deliveryDate = new Date();
    private String status;
    
    SimpleDateFormat formatter;

    public Invoice(int invoiceNumber, int PONumber, String supplierName, Date orderDate, Date deliveryDate, String status){
        this.invoiceNumber = invoiceNumber;
        this.PONumber = PONumber;
        this.supplierName = supplierName;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        
        formatter =new SimpleDateFormat("dd-MMM-yyyy"); 
    }
    
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getPONumber() {
        return PONumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setPONumber(int PONumber) {
        this.PONumber = PONumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getOrderDateString() {
        return formatter.format(orderDate);
    }

    public String getDeliveryDateString() {
        return formatter.format(deliveryDate);
    }
}

