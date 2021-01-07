package SiLO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author feral
 */
public class Item {

    public String getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getURL() {
        return URL;
    }  
    
    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

 
    
    private String id;
    private String barcode;
    private String title;
    private String description;
    private String manufacturer;
    private String URL;
}


