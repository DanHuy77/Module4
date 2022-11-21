package com.example.repository.impl;

import com.example.model.Sandwich;
import com.example.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {

    private static List<Sandwich> sandwichList = new ArrayList<>();

    static {
        sandwichList.add(new Sandwich(1, "sw1", ""));
        sandwichList.add(new Sandwich(2, "sw2", ""));
        sandwichList.add(new Sandwich(3, "sw3", ""));
        sandwichList.add(new Sandwich(4, "sw4", ""));
        sandwichList.add(new Sandwich(5, "sw5", ""));
    }

    @Override
    public List<Sandwich> showList() {
        return sandwichList;
    }

    @Override
    public void addCondiment(int id, String condiment) {
        for (Sandwich sandwich : sandwichList) {
            if (sandwich.getId() == id) {
                sandwich.setCondiments(condiment);
            }
        }
    }

    @Override
    public Sandwich findById(int id) {
        for (Sandwich sandwich : sandwichList) {
            if (sandwich.getId() == id) {
                return sandwich;
            }
        }
        return null;
    }
}
