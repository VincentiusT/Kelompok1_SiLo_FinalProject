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
public class ListItemCtl {

    
    public void getListItem(){
       
        String[] results =   dbHandler.getListItem();
        Item[] items = createItems(results);
        mainpage.showListItem(items);
    }
    
    private Item[] createItems (String[] results){
        return null;
    }
    private DBHandler dbHandler;
    private Item item[];
    private Mainpage mainpage;
    
    public void searchItem(String keyword){
        //dbHandler.searchItem(keyword);
    }
}

