package com.example.daopatern.dao;

import com.example.daopatern.model.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarDAO extends GenericDAO<CarModel>{
    @Override
    protected int extractId(CarModel item) {
        return item.getId();
    }

    @Override
    protected void setId(CarModel item, int id) {
        item.setId(id);
    }
}
