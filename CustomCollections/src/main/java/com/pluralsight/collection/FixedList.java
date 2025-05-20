package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    int maxSize;
    List<T> items;

    public FixedList(int maxSize){
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void add(T item){
        if (items.size() < this.maxSize){
            items.add(item);
        }
    }

    public List<T> getItems(){
        return this.items;
    }
}
