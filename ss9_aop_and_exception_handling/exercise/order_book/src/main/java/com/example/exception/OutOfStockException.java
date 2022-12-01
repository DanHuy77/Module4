package com.example.exception;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }

    public void quantityCheck(Integer quantity) throws OutOfStockException {
        if (quantity == 0) {
            throw new OutOfStockException("Not available!");
        }
        System.out.println("Succeed!");
    }
}
