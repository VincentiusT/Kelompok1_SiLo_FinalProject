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
    
    public void getInvoiceDescription(){
        //String[] result = dbHandler.getInvoiceDescriptionDB();
        //Invoice[] invoice = createInvoice(result);
        
        mainPage.showInvoiceDescription();
        
        
    }

    private Invoice[] createInvoice(String[] result) {
        return null;
    }

    void requestChangeStatus(String status) {
        dbHandler.changeStatus(status);
    }
}
