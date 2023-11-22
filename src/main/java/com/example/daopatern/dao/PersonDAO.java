package com.example.daopatern.dao;
import com.example.daopatern.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO extends GenericDAO<PersonModel>{
    @Override
    protected int extractId(PersonModel item) {
        return item.getId();
    }

    @Override
    protected void setId(PersonModel item, int id) {
        item.setId(id);
    }
}
