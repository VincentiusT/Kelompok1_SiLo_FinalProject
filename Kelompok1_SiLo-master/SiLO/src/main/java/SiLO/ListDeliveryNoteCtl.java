/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

import java.util.List;

/**
 *
 * @author VincentT
 */
public class ListDeliveryNoteCtl {
    
    private DBHandler dbHandler;
    private MainPage mainpage;
    
    public ListDeliveryNoteCtl(DBHandler dBHandler, MainPage mainpage){
        this.dbHandler = dBHandler;
        this.mainpage = mainpage;
    }
    
    public void getListDeliveryNote(){
        List<DeliveryNote> deliveryNotes = dbHandler.getListDeliveryNote();
        mainpage.showListDeliveryNote(deliveryNotes);
    }
    
    public void searchDeliveryNote(String keyword){
        List<DeliveryNote> ldn = dbHandler.searchDeliveryNote(keyword);
        mainpage.showListDeliveryNote(ldn);
    }
}
