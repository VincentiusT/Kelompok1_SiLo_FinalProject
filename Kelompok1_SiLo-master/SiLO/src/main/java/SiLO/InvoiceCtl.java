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
public class InvoiceCtl {
    
    private DBHandler dbHandler;
    private Mainpage mainPage;
    private DetailInvoicePage detailInvoicePage;
    
    int viewInvoiceIndex = 0;
    
    public InvoiceCtl(DBHandler dbHandler,Mainpage mainpage, DetailInvoicePage detailInvoicePage){
        this.dbHandler = dbHandler;
        this.mainPage = mainpage;
        this.detailInvoicePage = detailInvoicePage;
    }
    
    public void getInvoiceDescription(Invoice invoice, int index){
        //String[] result = dbHandler.getInvoiceDescriptionDB();
        //Invoice[] invoice = createInvoice(result);
        
        detailInvoicePage.setVisible(true);
        detailInvoicePage.setCurrentInvoice(invoice);
        viewInvoiceIndex = index;
        
        //mainPage.showInvoiceDescription();
    }

    private Invoice[] createInvoice(String[] result) {
        return null;
    }

    void requestChangeStatus(String status, String invoiceNumber) {
        detailInvoicePage.setVisible(false);
        dbHandler.changeInvoiceStatus(status, invoiceNumber);
        
        mainPage.refreshInvoiceList();
    }
}
