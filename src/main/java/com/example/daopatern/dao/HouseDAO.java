package com.example.daopatern.dao;

import com.example.daopatern.model.HouseModel;
import org.springframework.stereotype.Component;

@Component
public class HouseDAO extends GenericDAO<HouseModel> {
    @Override
    protected int extractId(HouseModel item) {
        return item.getId();
    }

    @Override
    protected void setId(HouseModel item, int id) {
        item.setId(id);
    }
}
