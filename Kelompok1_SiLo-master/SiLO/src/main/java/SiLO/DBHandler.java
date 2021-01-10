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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author feral
 */
public class DBHandler {

    private List<Item> items;
    private List<Invoice> invoices;
    private List<DeliveryNote> deliveryNotes;
    
    private SimpleDateFormat formatter;
    
    public DBHandler() throws ParseException{
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
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
    
    public void createDeliveryNoteData() throws ParseException{
        deliveryNotes = new ArrayList<DeliveryNote>();
        try{
            File dnDb = new File("DeliveryNoteData.txt");
            Scanner scanner = new Scanner(dnDb);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                String[] str = data.split("/");
                Date orderDate = null;
                Date deliveryDate = null;
                try{
                    orderDate = formatter.parse(str[3]);
                    deliveryDate = formatter.parse(str[4]);
                } catch(ParseException e){
                    
                }
                
                deliveryNotes.add(new DeliveryNote(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2],  orderDate, deliveryDate,str[5]));
            }
        } catch(FileNotFoundException e){}
    }
    
    public List<DeliveryNote> getListDeliveryNote(){
        return deliveryNotes;
    }
    
    public List<Item> getListItem() {
        return items;
    }
    
    public List<Item> searchItem(String keyword){
        List<Item> matchedItem = new ArrayList<Item>();
        for(int i=0; i<items.size(); i++){
            Item temp = items.get(i);
            if(temp.getId().toLowerCase().contains(keyword) ||
                    temp.getTitle().toLowerCase().contains(keyword) ||
                    temp.getManufacturer().toLowerCase().contains(keyword))
                matchedItem.add(temp);
        }
        
        List<Item> data = new ArrayList<Item>();
        for(int i=0; i<matchedItem.size(); i++){
            data.add(matchedItem.get(i));
        }
        return data;
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

    
    public void updateData(String id,String barcode,String description, String manufacturer, String title, String url, int stock, int index)
    {
        //update item data to database
        items.get(index).setId(id);
        items.get(index).setBarcode(barcode);
        items.get(index).setDescription(description);
        items.get(index).setManufacturer(manufacturer);
        items.get(index).setTitle(title);
        items.get(index).setTitle(title);
        items.get(index).setURL(url);
        items.get(index).setNumberOfStock(stock);
        
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
    
    public void insertData(String invoiceNumber, String deliveryNoteNumber, String CustomerName, String orderDate, String deliveryDate, String status) throws ParseException{
        //insert delivery note data to database
        deliveryNotes.add(new DeliveryNote(Integer.parseInt(invoiceNumber), Integer.parseInt(deliveryNoteNumber), CustomerName, formatter.parse(orderDate), formatter.parse(deliveryDate), status));
        try{
            FileWriter writer = new FileWriter("DeliveryNoteData.txt");
            for(int i=0; i<deliveryNotes.size(); i++){
                DeliveryNote temp = deliveryNotes.get(i);
                writer.write(
                    temp.getInvoiceNumber()+ "/" +
                    temp.getDeliveryNoteNumber()+ "/" +
                    temp.getCustomerName()+ "/" +
                    temp.getOrderDateString()+ "/" +
                    temp.getDeliveryDateString()+ "/" +
                    temp.getStatus()+ "/" +
                    "\n"
                );
            }
            writer.close();
        } catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
    
    public void changeDeliveryNoteStatus(String status, String deliveryNoteNumber) {
        for(int i=0; i<deliveryNotes.size(); i++){
            DeliveryNote temp = deliveryNotes.get(i);
            if(String.valueOf(temp.getDeliveryNoteNumber()).equals(deliveryNoteNumber)){
                temp.setStatus(status);
                break;
            }
        }
        
        try{
            FileWriter deliveryNoteDbWriter = new FileWriter("DeliveryNoteData.txt");
            
            for(int i=0; i<deliveryNotes.size(); i++){
                DeliveryNote temp = deliveryNotes.get(i);
                deliveryNoteDbWriter.write(
                    temp.getInvoiceNumber() + "/" +
                    temp.getDeliveryNoteNumber() + "/" +
                    temp.getCustomerName() + "/" +
                    temp.getOrderDateString() + "/" +
                    temp.getDeliveryDateString() + "/" +
                    temp.getStatus() + "\n"
                );
            }
            deliveryNoteDbWriter.close();
        } catch(IOException e){
            System.out.println("An error occurred.");
        }
    }

    public void changeInvoiceStatus(String status){
        
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

    public List<DeliveryNote> searchDeliveryNote(String keyword){
        List<DeliveryNote> matchedDeliveryNote = new ArrayList<DeliveryNote>();
        for(int i=0; i<deliveryNotes.size(); i++){
            DeliveryNote temp = deliveryNotes.get(i);
            if(String.valueOf(temp.getInvoiceNumber()).contains(keyword) ||
                String.valueOf(temp.getDeliveryNoteNumber()).contains(keyword) ||
                temp.getCustomerName().toLowerCase().contains(keyword) ||
                temp.getOrderDateString().contains(keyword) ||
                temp.getDeliveryDateString().contains(keyword) ||
                temp.getStatus().toLowerCase().contains(keyword))
                matchedDeliveryNote.add(temp);
        }
        
        List<DeliveryNote> data = new ArrayList<DeliveryNote>();
        for(int i=0; i<matchedDeliveryNote.size(); i++)
            data.add(matchedDeliveryNote.get(i));
        
        return data;
    }
 
}
