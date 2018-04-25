package com.mysql.example.demo.Models;

public class ProductModel
{
    private int id, webshopId, quantity;
    private String title;
    private double price;

    public ProductModel()
    {
    }

    public ProductModel(int id, int webshopId, int quantity, String title, double price)
    {
        this.id = id;
        this.webshopId = webshopId;
        this.quantity = quantity;
        this.title = title;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getWebshopId()
    {
        return webshopId;
    }

    public void setWebshopId(int webshopId)
    {
        this.webshopId = webshopId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String toSQl() {
        return "'" + title + "',";
    }
}
