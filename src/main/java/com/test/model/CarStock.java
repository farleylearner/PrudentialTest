package com.test.model;

/**
 * car stock
 */
public class CarStock {
    private String type;
    private Integer size;

    public CarStock(String type, Integer size) {
        this.type = type;
        this.size = size;
    }

    public CarStock() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
