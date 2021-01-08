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
public class ItemCtl {
    
    private DBHandler dbhandler;
    private Mainpage mainpage;
    
    private ItemForm addNewItemForm;
    private ItemForm editItemForm;
    
    public ItemCtl(DBHandler dbHandler,ItemForm addNewItemForm, ItemForm editItemForm){
        this.addNewItemForm = addNewItemForm;
        this.editItemForm = editItemForm;
        this.dbhandler = dbhandler;
    }
    
    public ItemCtl(){
        
    }
    
    public void requestNewItemForm() {
        addNewItemForm.setVisible(true);
    }
    
    public void requestEditItemForm(){
        editItemForm.setVisible(true);
    }
    
    public void submit(String barcode,String description, String manufacturer, String title, String url){
        addNewItemForm.setVisible(false);
        dbhandler.insertData(barcode, description, manufacturer, title, url);
        //mainpage.refreshItemList();
    }
    
    public void update(String barcode,String description, String manufacturer, String title, String url){
        editItemForm.setVisible(false);
        dbhandler.updateData(barcode, description, manufacturer, title, url);
        //mainpage.refreshItemList();
    }
    
    
}
