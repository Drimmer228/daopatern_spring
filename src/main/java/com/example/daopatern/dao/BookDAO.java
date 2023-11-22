package com.example.daopatern.dao;

import com.example.daopatern.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookDAO extends GenericDAO<BookModel>{
    @Override
    protected int extractId(BookModel item) {
        return item.getId();
    }

    @Override
    protected void setId(BookModel item, int id) {
        item.setId(id);
    }
}
