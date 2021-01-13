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
    private MainPage mainpage;
    
    private ItemForm addNewItemForm;
    private ItemForm editItemForm;
    
    public ItemCtl(DBHandler dbHandler,MainPage mainpage, ItemForm addNewItemForm, ItemForm editItemForm){
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
    
    
    
    public void submit(Item item){
        addNewItemForm.setVisible(false);
        dbhandler.insertData(item); 
        mainpage.refreshItemList();
    }
    
    public void update(Item item){
        editItemForm.setVisible(false);
        dbhandler.updateData(item, editItemIndex);
        mainpage.refreshItemList();
    }
    
    public void cancelAddNewItem(){
        addNewItemForm.setVisible(false);
    }
    
}
