/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

/**
 *
 * @author VincentT
 */
public class DeliveryNoteCtl {
    
    private DBHandler dbHandler;
    private DeliveryNoteForm deliveryNoteForm;
    private DeliveryNoteDetailPage deliveryNoteDetailPage;
    
    public DeliveryNoteCtl(){
        
    }
    
    public DeliveryNoteCtl(DBHandler dbHandler,DeliveryNoteForm deliveryNoteForm, DeliveryNoteDetailPage deliveryNoteDetailPage){
        this.deliveryNoteForm = deliveryNoteForm;
        this.deliveryNoteDetailPage = deliveryNoteDetailPage;
        this.dbHandler = dbHandler;
    }
    
    public void requestDeliveryNoteForm(){
        deliveryNoteForm.setVisible(true);
    }
    
    public void showDeliveryNoteDescription(){
        deliveryNoteDetailPage.setVisible(true);
    }
    
    public void addNewDeliveryNoteData(String invoiceNumber,String deliveryNoteNumber,String customerName,String orderDate,
            String deliveryDate,String status){
        dbHandler.insertData(invoiceNumber, deliveryNoteNumber, customerName, orderDate, deliveryDate, status);
//        System.out.println(invoiceNumber+deliveryNoteNumber+customerName+ orderDate+ deliveryDate+status);
        deliveryNoteForm.setVisible(false);
        
        showDeliveryNoteDescription();
        //refreshDeliveryNoteList
    }
    
    public void sendSoftCopyDone(){
        //beres kirim softcopy
        deliveryNoteDetailPage.setVisible(false);
    }
    
    public void requestPrint(){
        //print
        deliveryNoteDetailPage.setVisible(false);
    }
}
