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
public class ListInvoiceCtl {
    public void getListInvoice(){
       
        String[] results =   dbHandler.getListInvoice();
        Invoice[] invoices = createInvoice(results);
        mainpage.showDetailInvoicePage(invoices);
    }
    
  


    private Invoice[] createInvoice(String[] results) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void searchInvoice(String keyword){
        String[] results =   dbHandler.getListInvoice(keyword);
        Invoice[] invoices = createInvoice(results);
        mainpage.showListInvoice(invoices);
    }
    
    private DBHandler dbHandler;
    private Invoice invoices[];
    private Mainpage mainpage;
}
