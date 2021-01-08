/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

import java.util.List;

/**
 *
 * @author feral
 */
public class ListItemCtl {

    private DBHandler dbHandler;
    private Item item[];
    private Mainpage mainpage;
    
    public ListItemCtl(DBHandler dbHandler, Mainpage mainpage){
        this.dbHandler = dbHandler;
        this.mainpage = mainpage;
    }
    
    public void getListItem(){
       
        //Object[] results =   dbHandler.getListItem();
        List<Item> items = createItems();
        mainpage.showListItem(items);
    }
    
    private List<Item> createItems (){
        return dbHandler.getListItem();
    }
    
    public void searchItem(String keyword){
        //dbHandler.searchItem(keyword);
    }
}

