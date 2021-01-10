/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author VincentT
 */
public class DeliveryNoteCtl {
    
    private Mainpage mainpage;
    private DBHandler dbHandler;
    private DeliveryNoteForm deliveryNoteForm;
    private DeliveryNoteDetailPage deliveryNoteDetailPage;
    
    public DeliveryNoteCtl(){
        
    }
    
    public DeliveryNoteCtl(DBHandler dbHandler,Mainpage mainpage,DeliveryNoteForm deliveryNoteForm, DeliveryNoteDetailPage deliveryNoteDetailPage){
        this.deliveryNoteForm = deliveryNoteForm;
        this.deliveryNoteDetailPage = deliveryNoteDetailPage;
        this.dbHandler = dbHandler;
        this.mainpage = mainpage;
    }
    
    public void requestDeliveryNoteForm(){
        deliveryNoteForm.setVisible(true);
    }
    
    public void showDeliveryNoteDescription(DeliveryNote dn){
        deliveryNoteDetailPage.setVisible(true);
        deliveryNoteDetailPage.setCurrentDeliveryNote(dn);
    }
    
    public void addNewDeliveryNoteData(String invoiceNumber,String deliveryNoteNumber,String customerName,String orderDate,
            String deliveryDate,String status) throws ParseException{
        dbHandler.insertData(invoiceNumber, deliveryNoteNumber, customerName, orderDate, deliveryDate, status);
//        System.out.println(invoiceNumber+deliveryNoteNumber+customerName+ orderDate+ deliveryDate+status);
        deliveryNoteForm.setVisible(false);
        
        int lastIdx = dbHandler.getListDeliveryNote().size();
        DeliveryNote dn = dbHandler.getListDeliveryNote().get(lastIdx-1);
        
        showDeliveryNoteDescription(dn);
        mainpage.refreshDeliveryNoteList();
    }
    
    public void sendSoftCopyDone(){
        //beres kirim softcopy
        deliveryNoteDetailPage.setVisible(false);
    }
    
    public void requestPrint(){
        //print
        deliveryNoteDetailPage.setVisible(false);
    }
    
    public void requestChangeStatus(String currState, String deliveryNoteNumber){
        dbHandler.changeDeliveryNoteStatus(currState, deliveryNoteNumber);
        deliveryNoteDetailPage.setVisible(false);
        mainpage.refreshDeliveryNoteList();
    }
}
