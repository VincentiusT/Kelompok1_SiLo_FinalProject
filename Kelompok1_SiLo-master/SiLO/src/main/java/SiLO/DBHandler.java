/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

/**
 *
 * @author feral
 */
public class DBHandler {

    public String[] getListItem() {
        return null;
    }
    
    public void insertData(String barcode,String description, String manufacturer, String title, String url){
        //insert item data to database
    }

    
    public void updateData(String barcode,String description, String manufacturer, String title, String url)
    {
        //update item data to database

    }
    
    public void insertData(String invoiceNumber, String deliveryNoteNumber, String CustomerName, String orderDate, String deliveryDate, String status){
        //insert delivery note data to database
    }
    
    public void changeStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[] getInvoiceDescriptionDB() {
        return null;

    }

    String[] getListInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[] getListInvoice(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
}
