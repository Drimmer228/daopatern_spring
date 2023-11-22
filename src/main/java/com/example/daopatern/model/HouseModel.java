package com.example.daopatern.model;

public class HouseModel {
    private int id;
    private String address;
    private int bedrooms;
    private String type;

    public HouseModel() {}

    public HouseModel(int id, String address, int bedrooms, String type) {
        this.id = id;
        this.address = address;
        this.bedrooms = bedrooms;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
