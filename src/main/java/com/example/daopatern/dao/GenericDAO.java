package com.example.daopatern.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericDAO<T> {
    private final List<T> items = new ArrayList<>();
    private int idCounter = 1;

    public List<T> getAll() {
        return items;
    }

    public Optional<T> getById(int id) {
        return items.stream()
                .filter(item -> extractId(item) == id)
                .findFirst();
    }

    public void create(T item) {
        setId(item, idCounter++);
        items.add(item);
    }

    public void update(int id, T updatedItem) {
        Optional<T> existingItem = getById(id);
        existingItem.ifPresent(item -> {
            items.set(items.indexOf(item), updatedItem);
            setId(updatedItem, id);
        });
    }

    public void delete(int id) {
        getById(id).ifPresent(item -> items.remove(item));
    }

    protected abstract int extractId(T item);

    protected abstract void setId(T item, int id);
}
