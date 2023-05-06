package model;

import java.io.Serializable;

public class Pharmaceutical implements Serializable {
    private String name;
    private String ID;
    private int price;
    private int stock;

    public Pharmaceutical(String name, String ID, int price, int stock) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
