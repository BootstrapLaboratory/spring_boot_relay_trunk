package com.example.inventory.app;

public class DuplicateSkuException extends RuntimeException {

    public DuplicateSkuException(String sku) {
        super("Inventory item with SKU '" + sku + "' already exists");
    }
}
