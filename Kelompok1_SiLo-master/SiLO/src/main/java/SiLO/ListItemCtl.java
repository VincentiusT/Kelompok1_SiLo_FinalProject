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
        List<Item> items = dbHandler.getListItem();
        mainpage.showListItem(items);
    }
    
    
    public void searchItem(String keyword){
        List<Item> items = dbHandler.searchItem(keyword);
        mainpage.showListItem(items);
    }
}

