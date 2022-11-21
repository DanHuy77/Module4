package com.example.repository;

import com.example.model.Sandwich;

import java.util.List;

public interface ISandwichRepository {
    List<Sandwich> showList();
    void addCondiment(int id, String condiment);
    Sandwich findById(int id);
}
