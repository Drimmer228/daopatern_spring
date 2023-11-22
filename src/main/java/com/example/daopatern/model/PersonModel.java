package com.example.daopatern.model;

public class PersonModel {

    private int _id;
    private String _name;
    private int _age;
    private String _email;

    public  PersonModel(){}

    public PersonModel(int id, String name, int age, String email){
        _id = id;
        _name = name;
        _age = age;
        _email = email;
    }

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

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }
}
