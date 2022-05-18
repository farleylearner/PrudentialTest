package com.test.constant;

public enum CarModelEnum {
    TOYOTA_CAMRY("Toyota Camry"),
    BMW_650("BMW 650");

    private String type;
    CarModelEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
