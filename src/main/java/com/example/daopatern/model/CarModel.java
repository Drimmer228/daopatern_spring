package com.example.daopatern.model;

public class CarModel {
    private int _id;
    private String _make;
    private String _model;
    private int _year;

    public CarModel() {}

    public CarModel(int id, String make, String model, int year) {
        _id = id;
        _make = make;
        _model = model;
        _year = year;
    }

    // Геттеры и сеттеры для каждого поля
    public String getMake() {
        return _make;
    }

    public void setMake(String make) {
        this._make = make;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        this._model = model;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        this._year = year;
    }
}
