package com.example.daopatern.model;
public class BookModel {
    private int _id;
    private String _title;
    private String _author;
    private int _pageCount;

    public BookModel() {}

    public BookModel(int id, String title, String author, int pageCount) {
        _id = id;
        _title = title;
        _author = author;
        _pageCount = pageCount;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        this._author = author;
    }

    public int getPageCount() {
        return _pageCount;
    }

    public void setPageCount(int pageCount) {
        this._pageCount = pageCount;
    }
}
