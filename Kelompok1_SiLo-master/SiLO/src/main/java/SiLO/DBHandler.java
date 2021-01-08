/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiLO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author feral
 */
public class DBHandler {

    private List<Item> items;
    private List<Invoice> invoices;
    private List<DeliveryNote> deliveryNotes;
    
    public DBHandler(){
        createItemData();
        createInvoiceData();
        createDeliveryNoteData();
    }
    
    public void createItemData(){
        items = new ArrayList<Item>();
        
        try{
            File itemDb = new File("ItemData.txt");
            Scanner scanner = new Scanner(itemDb);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] str = data.split("/");
                //System.out.println(str[0] + "  " + str[1] + "  " + str[2] + "  " + str[3]);
                items.add(new Item(str[0], str[1], str[2], str[3], str[4], str[5], Integer.parseInt(str[6])));
               
            }
        } catch(FileNotFoundException e){}
        
        
    }
    
    public void createInvoiceData(){
        
    }
    
    public void createDeliveryNoteData(){
        
    }
    
    public List<Item> getListItem() {
        return items;
    }
    
    public void insertData(String id,String barcode,String description, String manufacturer, String title, String url, int stock){
        //insert item data to database
        items.add(new Item(id,barcode,description, manufacturer, title, url, stock));
        
        try{
            FileWriter writer = new FileWriter("ItemData.txt");
            
            for(int i=0; i<items.size(); i++){
                Item temp = items.get(i);
                writer.write(
                    temp.getId() + "/" +
                            temp.getBarcode() + "/" +
                            temp.getTitle() + "/" +
                            temp.getDescription() + "/" +
                            temp.getManufacturer() + "/" +
                            temp.getURL() + "/" +
                            Integer.toString(temp.getNumberOfStock()) + "\n"
                );
            }
            writer.close();
        } catch(IOException e){
            System.out.println("An error occurred.");
        }
    }

    
    public void updateData(String id,String barcode,String description, String manufacturer, String title, String url, int stock)
    {
        //update item data to database

    }
    
    public void insertData(String invoiceNumber, String deliveryNoteNumber, String CustomerName, String orderDate, String deliveryDate, String status){
        //insert delivery note data to database
    }
    
    public void changeStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[] getInvoiceDescriptionDB() {
        return null;

    }

    String[] getListInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[] getListInvoice(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
}
