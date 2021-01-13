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
    
    private MainPage mainpage;
    private DBHandler dbHandler;
    private DeliveryNoteForm deliveryNoteForm;
    private DeliveryNoteDetailPage deliveryNoteDetailPage;
    
    private int editDeliveryNoteIndex=0;
    
    public DeliveryNoteCtl(){
        
    }
    
    public DeliveryNoteCtl(DBHandler dbHandler,MainPage mainpage,DeliveryNoteForm deliveryNoteForm, DeliveryNoteDetailPage deliveryNoteDetailPage){
        this.deliveryNoteForm = deliveryNoteForm;
        this.deliveryNoteDetailPage = deliveryNoteDetailPage;
        this.dbHandler = dbHandler;
        this.mainpage = mainpage;
    }
    
    public void requestDeliveryNoteForm(){
        deliveryNoteForm.setVisible(true);
    }
    
    
    public void addNewDeliveryNoteData(DeliveryNote deliveryNote) throws ParseException{
        
        deliveryNoteForm.setVisible(false);
        dbHandler.insertData(deliveryNote);
        
        deliveryNoteDetailPage.setVisible(true);
        deliveryNoteDetailPage.setDeliveryNoteData(deliveryNote);
        
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
    
    public void getDeliveryNoteDesciption(DeliveryNote deliveryNote,int index){
        deliveryNoteDetailPage.setVisible(true);
        deliveryNoteDetailPage.setDeliveryNoteData(deliveryNote);
        editDeliveryNoteIndex = index;
    }
}
