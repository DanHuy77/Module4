package com.example.service.impl;

import com.example.service.IConverterService;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {

    @Override
    public double toUsd(double vnd) {
        return vnd / 23000;
    }

    @Override
    public double toVnd(double usd) {
        return usd * 23000;
    }
}
