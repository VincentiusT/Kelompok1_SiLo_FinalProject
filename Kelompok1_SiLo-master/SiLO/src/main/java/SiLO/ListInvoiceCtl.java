/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

import java.util.List;

/**
 *
 * @author feral
 */
public class ListInvoiceCtl {
    
    private DBHandler dbHandler;
    private Mainpage mainpage;
    
    public ListInvoiceCtl(DBHandler dbHandler, Mainpage mainpage){
        this.dbHandler = dbHandler;
        this.mainpage = mainpage;
    }
    
    public void getListInvoice(){
        List<Invoice> invoices = dbHandler.getListInvoice();
        mainpage.showListInvoice(invoices);
        
//        String[] results =   dbHandler.getListInvoice();
//        Invoice[] invoices = createInvoice(results);
//        mainpage.showDetailInvoicePage(invoices);
    }
    
  


    private Invoice[] createInvoice(String[] results) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void searchInvoice(String keyword){
//        String[] results =   dbHandler.getListInvoice(keyword);
//        Invoice[] invoices = createInvoice(results);
//        mainpage.showListInvoice(invoices);

        List<Invoice> inv = dbHandler.searchInvoice(keyword);
        mainpage.showListInvoice(inv);
    }
    
    
}
