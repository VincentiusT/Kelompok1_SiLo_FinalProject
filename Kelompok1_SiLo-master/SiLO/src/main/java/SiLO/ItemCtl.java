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
    
    int editItemIndex = 0;
    
    private DBHandler dbhandler;
    private Mainpage mainpage;
    
    private ItemForm addNewItemForm;
    private ItemForm editItemForm;
    
    public ItemCtl(DBHandler dbHandler,Mainpage mainpage, ItemForm addNewItemForm, ItemForm editItemForm){
        this.addNewItemForm = addNewItemForm;
        this.editItemForm = editItemForm;
        this.dbhandler = dbHandler;
        this.mainpage = mainpage;
    }
    
    public ItemCtl(){
        
    }
    
    public void requestNewItemForm() {
        addNewItemForm.setVisible(true);
    }
    
    public void requestEditItemForm(Item item, int index){
        editItemForm.setEditData(item);
        editItemForm.setVisible(true);
        editItemIndex = index;
    }
    
    public void submit(String id, String barcode,String description, String manufacturer, String title, String url, int stock){
        addNewItemForm.setVisible(false);
        dbhandler.insertData(id,barcode, description, manufacturer, title, url,stock); 
        mainpage.refreshItemList();
    }
    
    public void update(String id,String barcode,String description, String manufacturer, String title, String url, int stock){
        editItemForm.setVisible(false);
        dbhandler.updateData(id, barcode, description, manufacturer, title, url,stock, editItemIndex);
        mainpage.refreshItemList();
    }
    
    
}
