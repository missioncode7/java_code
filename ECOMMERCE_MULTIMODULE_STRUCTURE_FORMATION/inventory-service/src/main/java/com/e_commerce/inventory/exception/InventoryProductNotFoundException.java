package com.e_commerce.inventory.exception;

public class InventoryProductNotFoundException extends RuntimeException {
    public InventoryProductNotFoundException(String message) {
        super(message);
    }

    public InventoryProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryProductNotFoundException(Throwable cause) {
        super(cause);
    }
}
