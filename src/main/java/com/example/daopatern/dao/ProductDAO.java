package com.example.daopatern.dao;

import com.example.daopatern.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO  extends GenericDAO<ProductModel>{
    @Override
    protected int extractId(ProductModel item) {
        return item.getId();
    }

    @Override
    protected void setId(ProductModel item, int id) {
        item.setId(id);
    }
}
