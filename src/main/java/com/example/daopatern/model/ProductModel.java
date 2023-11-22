package com.example.daopatern.model;

public class ProductModel {
    private int _id;
    private String _name;
    private double _price;
    private int _quantity;

    public ProductModel() {}

    public ProductModel(int id, String name, double price, int quantity) {
        _id = id;
        _name = name;
        _price = price;
        _quantity = quantity;
    }

    // Геттеры и сеттеры для каждого поля
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }
}
