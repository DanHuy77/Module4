package com.example.service;

import com.example.model.Sandwich;

import java.util.List;

public interface ISandwichService {
    List<Sandwich> showList();
    void addCondiment(int id, String condiment);
    Sandwich findById(int id);
}
