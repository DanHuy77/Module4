package com.example.service.impl;

import com.example.model.Sandwich;
import com.example.repository.ISandwichRepository;
import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> showList() {
        return sandwichRepository.showList();
    }

    @Override
    public void addCondiment(int id, String condiment) {
        sandwichRepository.addCondiment(id, condiment);
    }

    @Override
    public Sandwich findById(int id) {
        return sandwichRepository.findById(id);
    }
}
