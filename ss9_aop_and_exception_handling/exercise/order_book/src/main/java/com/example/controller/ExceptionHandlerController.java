package com.example.controller;

import com.example.exception.OutOfStockException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlerController {
    @ExceptionHandler(OutOfStockException.class)
    public String toExceptionPage() {
        return "error";
    }
}
